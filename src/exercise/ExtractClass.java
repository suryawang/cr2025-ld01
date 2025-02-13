package exercise;
public class ExtractClass {
// todo extract class TelephoneNumber from class Person
	class Person {
	  private String name;
	  private String officeAreaCode;
	  private String officeNumber;

	  public String getName() {
		return name;
	  }
	  public String getTelephoneNumber() {
		return ("(" + officeAreaCode + ") " + officeNumber);
	  }
	  public String getOfficeAreaCode() {
		return officeAreaCode;
	  }
	  public void setOfficeAreaCode(String arg) {
		officeAreaCode = arg;
	  }
	  public String getOfficeNumber() {
		return officeNumber;
	  }
	  public void setOfficeNumber(String arg) {
		officeNumber = arg;
	  }
	}
}