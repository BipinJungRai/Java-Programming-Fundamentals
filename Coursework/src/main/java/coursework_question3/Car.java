package coursework_question3;

public class Car {
  private int id;
  private String name;
  private String colour;
  private double reservedPrice;
  private CarType gearbox;
  private CarBody body;
  private int numberOfSeats;
  private Condition condition;
  private SaleType type;

  public Car(int id, String name, double reservedPrice, Condition condition, SaleType type) {

    if (id <= 0 || name == null || reservedPrice <= 0) {

      throw new IllegalArgumentException();
    }
    this.id = id;
    this.name = name;
    this.reservedPrice = reservedPrice;
    this.condition = condition;
    this.type = type;
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

  public int getID() {
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

  public SaleType getType() {
    return type;
  }

  public void setType(SaleType type) {
    this.type = type;
  }



}
