package coursework_question3;

import java.util.HashMap;
import java.util.Map;

public class Auctioneer extends Dealership {


  public Auctioneer(String name) {
    super(name);

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
    return "Statistics";
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



}
