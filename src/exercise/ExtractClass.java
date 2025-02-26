package exercise;
public class ExtractClass {

	class Person {
	  private String name;
	  private TelephoneNumber telephoneNumber = new TelephoneNumber();
	  public String getName() {
		return name;
	  }
         public string getTelephoneNumber() {
		 return telephoneNumber.getTelephoneNumber();	
	 }
	}
	class TelephoneNumber {
	  private String officeAreaCode;
	  private String officeNumber;

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
