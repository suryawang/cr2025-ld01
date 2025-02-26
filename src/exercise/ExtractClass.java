package exercise;
public class ExtractClass {
// todo extract class TelephoneNumber from class Person
	class Person {
	  private String name;
	  private TelephoneNumber number;
	  
	  public String getName() {
		return name;
	  }
	  public String getTelephoneNumber() {
		return number.getTelephoneNumber();
	  }
	  public String getOfficeAreaCode() {
		return number.getOfficeAreaCode();
	  }
	  public void setOfficeAreaCode(String arg) {
		number.setOfficeAreaCode(arg);
	  }
	  public String getOfficeNumber() {
		return number.getOfficeNumber();
	  }
	  public void setOfficeNumber(String arg) {
		number.setOfficeNumber(arg);
	  }
	}
	class TelephoneNumber{
		private String officeAreaCode;
		private String officeNumber;
		
		public TelephoneNumber(String officeAreaCode, String officeNumber) {
			this.officeAreaCode=officeAreaCode;
			this.officeNumber = officeNumber;
		}
		public String getOfficeAreaCode() {
	        return officeAreaCode;
	    }

	    public void setOfficeAreaCode(String officeAreaCode) {
	        this.officeAreaCode = officeAreaCode;
	    }

	    public String getOfficeNumber() {
	        return officeNumber;
	    }

	    public void setOfficeNumber(String officeNumber) {
	        this.officeNumber = officeNumber;
	    }
	    public String getTelephoneNumber() {
			return ("(" + this.officeAreaCode + ") " + this.officeNumber);
		  }
	}
}
