package coursework_question4;

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
    return getName() + " " + lastLetter + ". (Sales: " + getSales() + ", " + identifyRating();
  }

  public String identifyRating() {

    int lvl = 0;
    if (sales >= 1 && sales < 6) {
      lvl = 1;
    }
    if (sales > 5 && sales < 11) {
      lvl = 2;
    }
    if (sales > 10) {
      lvl = 3;
    }
    return "Rating: Level " + lvl + ")";
  }

  public void setSales(int sales) {
    this.sales = sales;
  }



}
