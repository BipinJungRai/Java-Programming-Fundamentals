package coursework_question1;

import java.util.ArrayList;
import java.util.List;

public class Advert {
  private Car car;
  private List<Offer> offers;

  public Advert(Car car) {

    if (car == null) {
      throw new IllegalArgumentException();

    }

    this.car = car;
    offers = new ArrayList<>();
  }

  public Offer getHighestOffer() {
    Offer firstOffer = offers.get(0);
    for (Offer offer : offers) {
      if (offer.getValue() > firstOffer.getValue()) {
        firstOffer = offer;
      }
    }
    return firstOffer;
  }

  public boolean placeOffer(User buyer, double value) {
    try {
      Offer offer = new Offer(buyer, value);
      offers.add(offer);
      return true;
    } catch (Exception e) {
      return false;
    }

  }

  @Override
  public String toString() {
    return "Ad: " + car.displayCarSpecification() + "\n";
  }

  public Car getCar() {
    return car;
  }

  public List<Offer> getOffers() {
    return offers;
  }



}
