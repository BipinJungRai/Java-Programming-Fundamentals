package coursework_question4;

public class Buyer extends User {
  private int age;

  public Buyer(String fullname, int age) {
    super(fullname);
    if (age < 18) {
      throw new IllegalArgumentException();
    } else {
      this.age = age;
    }
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    String firstLetter = getName().substring(0, 1);
    String lastLetter = getName().substring(getName().length() - 1);

    return firstLetter + "***" + lastLetter;
  }

}
