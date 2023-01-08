package coursework_question1;

import java.util.HashMap;
import java.util.Map;

public class Auctioneer {

  protected String name;

  protected HashMap<Advert, User> carsForSale;

  protected HashMap<Advert, User> soldCars;

  protected HashMap<Advert, User> unsoldCars;

  public Auctioneer(String name) {
    this.name = name;
    carsForSale = new HashMap<>();
    soldCars = new HashMap<>();
    unsoldCars = new HashMap<>();
  }

  public boolean checkExistence(Car car) {
    boolean check = false;
    for (Map.Entry<Advert, User> entry : carsForSale.entrySet()) {
      if (entry.getKey().getCar() == car) {
        check = true;
      }
    }
    return check;
  }

  public String displaySoldCars() {
    String output = "SOLD CARS:\n";
    for (Map.Entry<Advert, User> entry : soldCars.entrySet()) {
      output = output + entry.getKey().getCar().getId() + " - Purchased by " + name
          + " with a successful £"
          + String.format("%.2f", entry.getKey().getHighestOffer().getValue()) + " bid.\n";
    }
    return output;
  }

  public String displayStatistics() {
    return "Statistics";
  }

  public String displayUnsoldCars() {
    String output = "UNSOLD CARS:\n";
    for (Map.Entry<Advert, User> entry : unsoldCars.entrySet()) {
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
    carsForSale.put(carAdvert, user);
  }



}
