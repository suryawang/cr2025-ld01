package large_class;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInputer {
	private Scanner scan;
	private String message;
	private String format;
	public DateInputer(Scanner scan, String message, String format) {
		super();
		this.scan = scan;
		this.message = message;
		this.format = format;
	}
	public Date get() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		
		Date date = null;
		do {
			try {
				System.out.print(message + " ["+format+"]: ");
				String input = scan.nextLine().trim();
				date = sdf.parse(input);
			} catch (Exception e) {
				date = null;
			}
		} while(date == null);
		return date;
	}
}
