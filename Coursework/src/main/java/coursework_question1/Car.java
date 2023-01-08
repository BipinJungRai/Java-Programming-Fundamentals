package coursework_question1;

public class Car {
  private int id;
  private String name;
  private String colour;
  private double reservedPrice;
  private CarType gearbox;
  private CarBody body;
  private int numberOfSeats;
  private Condition condition;

  public Car(int id, String name, double reservedPrice, Condition condition) {

    if (id <= 0 || name == null || reservedPrice <= 0) {

      throw new IllegalArgumentException();
    }
    this.id = id;
    this.name = name;
    this.reservedPrice = reservedPrice;
    this.condition = condition;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public CarType getGearbox() {
    return gearbox;
  }

  public void setGearbox(CarType gearbox) {
    this.gearbox = gearbox;
  }

  public CarBody getBodyStyle() {
    return body;
  }

  public void setBody(CarBody body) {
    this.body = body;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return reservedPrice;
  }

  @Override
  public String toString() {
    return id + " - " + name;
  }

  public String displayCarSpecification() {
    return toString() + " (£" + String.format("%.2f", reservedPrice) + ")\n" + "\t" + "Type: "
        + gearbox + "\n" + "\t" + "Style: " + body + "\n" + "\t" + "Colour: " + colour + "\n" + "\t"
        + "No. of Seats: " + numberOfSeats + "\n" + "\t" + "Condition: " + condition;
  }



}
