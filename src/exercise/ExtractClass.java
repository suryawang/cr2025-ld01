package exercise;
public class ExtractClass {
// todo extract class TelephoneNumber from class Person

	
      class TelephoneNumber{
	private String areaCode;
	private String number;

	public String getAreaCode(){
		return areaCode;
	}
	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}
	public String getNUmber(){
		return number;
	}
	public void setNumver(String number){
		this.number = number;
	}
	 public String getTelephoneNumber(){
		return "(" + areaCode + ")" + number;
		 
	 }
		
}


	class Person{
		private String nae:
		private TelephoneNumber telephoneNumber= new TelephoneNumber();

		public String getName(){
			return name;
		}
		public String getTelephoneNumer(){
			return telephoheNumber.getTelephoneNumber();
		}
		public String getOfficeAreaCode(){
			return telephoneNumber.getAreaCode();
		}
		public void setOfficeAreaCode(string arg){
			telephoneNUmber.setAreaCode(arg);
		}
		public String getOfficeNumber(){
			return telephoneNumber.getNumber();
		}
		public void setOfficeNumber(String arg) {
			telephoneNUmber.setNumber(arg);
		}
	}
}
