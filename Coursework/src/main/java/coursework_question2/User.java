package coursework_question2;

public class User {
  private String fullname;

  public User(String fullname) {
    if (!fullname.matches("[A-Z]{1}[a-z]* [A-Z]{1}[a-z]*")) {
      throw new IllegalArgumentException();
    }
    this.fullname = fullname;
  }

  public String getName() {
    String output = fullname.substring(0, fullname.indexOf(' '));
    return output;
  }

  @Override
  public String toString() {
    return fullname;
  }
}
