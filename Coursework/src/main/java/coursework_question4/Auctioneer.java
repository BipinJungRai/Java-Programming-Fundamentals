package coursework_question4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Auctioneer extends Dealership {


  public Auctioneer(String name) {
    super(name);
    topSeller = new Seller("Null Null");
    sales = new HashMap<>();

  }

  private HashMap<Seller, Integer> sales;
  private Seller topSeller;

  public boolean checkExistence(Car car) {
    boolean check = false;
    for (Map.Entry<Advert, Seller> entry : carsForSale.entrySet()) {
      if (entry.getKey().getCar() == car) {
        check = true;
      }
    }
    return check;
  }

  public String displaySoldCars() {
    String output = "SOLD CARS:\n";
    for (Map.Entry<Advert, Buyer> entry : soldCars.entrySet()) {
      output = output + entry.getKey().getCar().getID() + " - Purchased by "
          + entry.getValue().toString() + " with a successful £"
          + String.format("%.2f", entry.getKey().getHighestOffer().getValue()) + " bid.\n";
    }
    return output;
  }

  public String displayStatistics() {
    String output = "** Auctioneer - " + name + "**\n";

    BufferedReader r = null;
    try {
      r = new BufferedReader(new FileReader("auction_statistics.txt"));
      String line = r.readLine();

      while (line != null) {
        output = output + line + "\n";
        break;
      }
      output = output.substring(0, output.length() - 1);
      r.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return output;
  }

  public String displayUnsoldCars() {
    String output = "UNSOLD CARS:\n";
    for (Map.Entry<Advert, Seller> entry : unsoldCars.entrySet()) {
      output = output + entry.getKey().toString();
    }
    return output;
  }

  public void endSale(Advert advert) {
    if (advert == null) {
      throw new IllegalArgumentException();
    }
    if (!carsForSale.containsKey(advert)) {
      return;
    }

    if (advert.getHighestOffer().getValue() >= advert.getCar().getPrice()) {
      soldCars.put(advert, advert.getHighestOffer().getBuyer());
      updateStatistics(carsForSale.get(advert));
      carsForSale.remove(advert);
    } else {
      unsoldCars.put(advert, carsForSale.get(advert));
      carsForSale.remove(advert);
    }
  }

  public boolean placeOffer(Advert carAdvert, User user, double value) {
    if (carAdvert == null || user == null) {
      throw new IllegalArgumentException();

    }
    boolean offer = false;
    if (checkExistence(carAdvert.getCar())) {
      carAdvert.placeOffer(user, value);
      return true;

    } else {
      return false;
    }
  }

  public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body,
      int noOfSeats) {

    if (carAdvert == null || user == null) {
      throw new IllegalArgumentException();
    }
    carAdvert.getCar().setColour(colour);
    carAdvert.getCar().setNumberOfSeats(noOfSeats);
    carAdvert.getCar().setGearbox(type);
    carAdvert.getCar().setBody(body);

    if (checkExistence(carAdvert.getCar())) {
      return;
    }
    carsForSale.put(carAdvert, (Seller) user);
  }


  private void saveInFile(int noOfSales, double percentageOfManual, double percentageOfAutomatic) {
    FileWriter fileWriter = null;
    BufferedWriter bufferedWriter = null;
    try {
      fileWriter = new FileWriter("auction_statistics.txt");
      bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write("Total Auction Sales: " + noOfSales);
      bufferedWriter.newLine();
      bufferedWriter.write("Automatic Cars: " + percentageOfAutomatic);
      bufferedWriter.newLine();
      bufferedWriter.write("Manual Cars: " + percentageOfManual);
      bufferedWriter.newLine();
      bufferedWriter.write("Top Seller: " + topSeller.toString());
    } catch (IOException e) {
      System.err.format("IOException: %s%n", e);
    } finally {
      try {
        if (bufferedWriter != null)
          bufferedWriter.close();

        if (fileWriter != null)
          fileWriter.close();
      } catch (IOException ex) {
        System.err.format("IOException: %s%n", ex);
      }
    }
  }

  private void updateStatistics(Seller seller) {
    seller.setSales(seller.getSales() + 1);

    if (sales.containsKey(seller)) {
      for (Map.Entry<Seller, Integer> entry : sales.entrySet()) {
        if (entry.getKey() == seller) {
          entry.setValue(entry.getValue() + 1);
        }
      }
    } else {
      sales.put(seller, 1);
    }

    for (Map.Entry<Seller, Integer> entry : sales.entrySet()) {
      if (entry.getValue() > topSeller.getSales() || topSeller == null) {
        topSeller = entry.getKey();
      }
    }

    int manual = 0;
    int automatic = 0;

    for (Map.Entry<Advert, Buyer> entry : soldCars.entrySet()) {
      if (entry.getKey().getCar().getGearbox() == CarType.AUTOMATIC) {
        automatic++;
      } else {
        manual++;
      }
    }
    int tSales = soldCars.size();

    double pMan = manual * 100 / tSales;
    double pAuto = automatic * 100 / tSales;

    saveInFile(tSales, pMan, pAuto);
  }
}


