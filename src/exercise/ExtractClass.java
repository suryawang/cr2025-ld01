package exercise;
public class ExtractClass {
// todo extract class TelephoneNumber from class Person
	class Person {
	  private PersonData data = new PersonData();

	public String getName() {
		return data.name;
	  }
	  public String getTelephoneNumber() {
		return ("(" + data.officeAreaCode + ") " + data.officeNumber);
	  }
	  public String getOfficeAreaCode() {
		return data.officeAreaCode;
	  }
	  public void setOfficeAreaCode(String arg) {
		data.officeAreaCode = arg;
	  }
	  public String getOfficeNumber() {
		return data.officeNumber;
	  }
	  public void setOfficeNumber(String arg) {
		data.officeNumber = arg;
	  }
	}
}
