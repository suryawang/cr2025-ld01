package long_method;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

public class SemesterMenu {
	private Vector<Semester> semesters;
	private Scanner scan;

	public SemesterMenu() {
		semesters = new Vector<Semester>();
		scan = new Scanner(System.in);
	}

	public void open() {
		while (menu()) {
		}
	}

	private boolean menu() {
		showAllSemesters();
		displayMenuList();

		switch (chooseMenu()) {
		case 1: create(); break;
		case 2: delete(); break;
		case 3: return false;
		}
		return true;
	}

	private int chooseMenu() {
		int input = 0;
		do {
			System.out.print("Input [1-3]: ");
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = 0;
			} finally {
				scan.nextLine();
			}
		} while (input < 1 || input > 3);
		return input;
	}

	private void displayMenuList() {
		System.out.println("1. Create");
		System.out.println("2. Delete");
		System.out.println("3. Exit");
	}

	private void showAllSemesters() {
		for (int i = 0; i < semesters.size(); i++) {
			Semester s = semesters.elementAt(i);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			System.out.print((i + 1) + ". ");
			System.out.print(s.getLabel());
			System.out.print(" - ");
			System.out.print(format.format(s.getStart()));
			System.out.print(" - ");
			System.out.print(format.format(s.getEnd()));
			System.out.println("");
		}
		System.out.println("");
	}

	private void delete() {
		int input = 0;
		do {
			System.out.print("Choose semester [1-" + semesters.size() + "]: ");
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = 0;
			} finally {
				scan.nextLine();
			}
		} while (input < 1 || input > semesters.size());
		semesters.removeElementAt(input - 1);
	}

	private void create() {
		String label = inputSemesterLabel();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);

		Date startDate = null;
		Date endDate = null;

		do {
			startDate = inputStartDate(format);
			endDate = inputEndDate(format);
		} while (startDate.after(endDate));

		semesters.add(new Semester(label, startDate, endDate));
	}

	private Date inputEndDate(SimpleDateFormat format) {
		Date endDate;
		do {
			try {
				System.out.print("Input end date [yyyy-MM-dd]: ");
				String input = scan.nextLine().trim();
				endDate = format.parse(input);
			} catch (Exception e) {
				endDate = null;
			}
		} while (endDate == null);
		return endDate;
	}

	private Date inputStartDate(SimpleDateFormat format) {
		Date startDate;
		do {
			try {
				System.out.print("Input start date [yyyy-MM-dd]: ");
				String input = scan.nextLine().trim();
				startDate = format.parse(input);
			} catch (Exception e) {
				startDate = null;
			}
		} while (startDate == null);
		return startDate;
	}

	private String inputSemesterLabel() {
		String label = "";
		do {
			System.out.print("Input label [3-20 chars]: ");
			label = scan.nextLine().trim();
		} while (label.length() < 3 || label.length() > 20 || !isLabelUnique(label));
		return label;
	}

	private boolean isLabelUnique(String label) {
		for (Semester s : semesters) {
			if (s.getLabel().equalsIgnoreCase(label))
				return false;
		}
		return true;
	}
}
