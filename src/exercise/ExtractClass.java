package exercise;

public class ExtractClass {
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

    class Person {
        private String name;
        private TelephoneNumber telephoneNumber = new TelephoneNumber();

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return telephoneNumber.getTelephoneNumber();
        }

        public String getOfficeAreaCode() {
            return telephoneNumber.getOfficeAreaCode();
        }

        public void setOfficeAreaCode(String arg) {
            telephoneNumber.setOfficeAreaCode(arg);
        }

        public String getOfficeNumber() {
            return telephoneNumber.getOfficeNumber();
        }

        public void setOfficeNumber(String arg) {
            telephoneNumber.setOfficeNumber(arg);
        }
    }
}
