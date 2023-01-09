package coursework_question4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Trader extends Dealership {

  private List<Seller> sellers;

  public Trader(String name) {
    super(name);
    this.sellers = new ArrayList<>();

  }

  private boolean checkExistence(Car car) {
    boolean check = false;
    for (Map.Entry<Advert, Seller> entry : carsForSale.entrySet()) {
      if (entry.getKey().getCar() == car) {
        check = true;
      }
    }
    return check;
  }

  @Override
  public String displaySoldCars() {
    String output = "SOLD CARS:\n";
    for (Map.Entry<Advert, Buyer> entry : soldCars.entrySet()) {
      output = output + entry.getKey().getCar().getID() + " - Purchased by "
          + entry.getValue().toString() + " with a successful £"
          + String.format("%.2f", entry.getKey().getHighestOffer().getValue()) + " bid.\n";
    }
    return output;
  }

  @Override
  public String displayUnsoldCars() {
    String output = "UNSOLD CARS:\n";
    for (Map.Entry<Advert, Seller> entry : unsoldCars.entrySet()) {
      output = output + entry.getKey().toString();
    }
    return output;
  }


  @Override
  public String displayStatistics() {
    String statistics = "";
    double totalSales = 0;
    String allSellers = "";
    for (Map.Entry<Advert, Buyer> entry : soldCars.entrySet()) {
      totalSales += entry.getKey().getHighestOffer().getValue();
      allSellers += entry.getValue().getName() + "\n";
    }
    statistics = "** Trader - " + name + "**\nTotal Sales: " + this.soldCars.size()
        + "\nAll Sellers:\n" + allSellers;
    return statistics.substring(0, statistics.length() - 1);
  }



  @Override
  public boolean placeOffer(Advert carAdvert, User user, double value) {
    if (carAdvert == null || user == null || value <= 0) {
      throw new IllegalArgumentException();

    }
    boolean placeOffer = false;
    if (carsForSale.containsKey(carAdvert)) {
      if (value >= carAdvert.getCar().getPrice()) {
        carAdvert.placeOffer(user, value);
        endSale(carAdvert);
        soldCars.put(carAdvert, (Buyer) carAdvert.getHighestOffer().getBuyer());
        placeOffer = true;
      } else {
        unsoldCars.put(carAdvert, null);
      }

    }
    return placeOffer;
  }



  private void endSale(Advert advert) {
    if (advert == null) {
      throw new IllegalArgumentException();
    }
    if (!carsForSale.containsKey(advert)) {
      return;
    }

    if (advert.getHighestOffer().getValue() >= advert.getCar().getPrice()) {
      soldCars.put(advert, advert.getHighestOffer().getBuyer());
      carsForSale.remove(advert);
    } else {
      unsoldCars.put(advert, carsForSale.get(advert));
      carsForSale.remove(advert);
    }
  }

  @Override
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
}

