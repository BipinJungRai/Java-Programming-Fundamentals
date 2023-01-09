package coursework_question4;

public abstract class User {
  private String fullname;

  public User(String fullname) {
    super();
    boolean UserFullname = fullname.matches("([A-Z][a-z]*)[ ]([A-Z][a-z]*)");
    if (UserFullname == false) {
      throw new IllegalArgumentException();
    }
    this.fullname = fullname;

  }

  public String getName() {
    String[] splitnames = fullname.split(" ");
    String fname = splitnames[0];
    return fname;
  }

  @Override
  public String toString() {
    return fullname;
  }

  public String getFullName() {
    return fullname;
  }


}
