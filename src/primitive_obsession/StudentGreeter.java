package primitive_obsession;

public class StudentGreeter {
	public void greet(Student m) {
		if(m.getType().equals("reguler")) {
			System.out.println("Selamat Datang, " + m.getName());
		} else if(m.getType().equals("global")) {
			System.out.println("Welcome, " + m.getName());
		}
	}
}
