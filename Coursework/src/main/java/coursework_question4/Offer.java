package coursework_question4;

public class Offer {
  private double value;
  private User buyer;

  public Offer(User buyer, double value) {
    if (buyer == null || value <= 0) {
      throw new IllegalArgumentException();
    }
    this.value = value;
    this.buyer = buyer;
  }

  public Buyer getBuyer() {
    return (Buyer) buyer;
  }

  @Override
  public String toString() {
    return buyer.toString() + " offered £" + String.format("%.2f", value);

  }

  public double getValue() {
    return value;
  }



}
