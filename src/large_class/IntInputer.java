package large_class;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IntInputer {
	private Scanner scan;
	private String message;
	private int min;
	private int max;
	public IntInputer(Scanner scan, String message, int min, int max) {
		super();
		this.scan = scan;
		this.message = message;
		this.min = min;
		this.max = max;
	}
	public int get() {
		int input;
		do{
			System.out.print(message + " ["+min+"-"+max+"]: ");
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = 0;
			} finally {
				scan.nextLine();
			}
		}while(input < min || input > max);
		return input;
	}
}
