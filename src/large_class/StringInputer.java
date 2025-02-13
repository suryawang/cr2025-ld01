package large_class;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StringInputer {
	private Scanner scan;
	private String message;
	private int min;
	private int max;
	public StringInputer(Scanner scan, String message, int min, int max) {
		super();
		this.scan = scan;
		this.message = message;
		this.min = min;
		this.max = max;
	}
	public String get() {
		String input;
		do{
			System.out.print(message + " ["+min+"-"+max+" chars]: ");
			input = scan.nextLine().trim();
		}while(input.length() < min || input.length() > max);
		return input;
	}
}
