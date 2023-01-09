package coursework_question3;

public class Seller extends User {
  private int sales;

  public Seller(String name) {
    super(name);
  }

  public int getSales() {
    return sales;
  }

  @Override
  public String toString() {
    char lastLetter = getFullName().charAt(4);
    return getName() + " " + lastLetter + ". ()";
  }


}
