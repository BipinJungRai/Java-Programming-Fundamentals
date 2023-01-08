package coursework_question1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdvertJTest {

  Advert advert = null;
  Car car = new Car(1111, "Ferrari", 2222, Condition.NEW);
  User user1 = new User("Jr Smith");
  User user2 = new User("Walter White");

  @Test
  public void coursework_testAdvertConstruction() {
    advert = new Advert(car);

    assertEquals(car, advert.getCar());
  }

  @Test(expected = IllegalArgumentException.class)
  public void coursework_testInvalidAdvert() {
    advert = new Advert(null);
  }

  @Test
  public void coursework_testToString() {
    advert = new Advert(car);
    car.setBody(CarBody.SUPERCAR);
    car.setColour("Hot Pink");
    car.setGearbox(CarType.AUTOMATIC);
    car.setNumberOfSeats(2);

    assertEquals("Ad: " + car.displayCarSpecification() + "\n", advert.toString());
  }


  @Test
  public void coursework_testPlaceOffer() {
    Offer offer = new Offer(user2, 5000);
    advert = new Advert(car);
    advert.placeOffer(user2, 5000);

    assertEquals(offer.toString(), advert.getOffers().get(0).toString());
  }

  @Test
  public void coursework_testHighestOffer() {
    advert = new Advert(car);
    advert.placeOffer(user1, 1000);
    advert.placeOffer(user2, 5000);

    assertEquals(user2.getName(), advert.getHighestOffer().getBuyer().getName());
  }
}
