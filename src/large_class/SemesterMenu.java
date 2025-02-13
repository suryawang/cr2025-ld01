package large_class;

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
		while(menu()) {}
	}

	private boolean menu(){
		showSemesters();
		int input = printAndGetMenu();
		switch(input){
		case 1: create(); break;
		case 2: delete(); break;
		case 3: return false;
		}
		return true;
	}

	private void create() {		
		String label;
		do {
			label = new StringInputer(scan, "Input label", 3, 20).get();
		} while(!isLabelUnique(label));
		
		Date startDate, endDate;
		do {
			startDate = new DateInputer(scan, "Input start date", "yyyy-MM-dd").get();	
			endDate = new DateInputer(scan, "Input end date", "yyyy-MM-dd").get();
		} while(startDate.after(endDate));

		semesters.add(new Semester(label, startDate, endDate));
	}
	
	private boolean isLabelUnique(String label) {
		for(Semester s : semesters) {
			if(s.getLabel().equalsIgnoreCase(label)) return false;
		}
		return true;
	}

	private void delete() {
		int input = new IntInputer(scan,"Choose semester", 1, semesters.size()).get();
		semesters.removeElementAt(input-1);
	}
	
	private int printAndGetMenu() {
		System.out.println("1. Create");
		System.out.println("2. Delete");
		System.out.println("3. Exit");
		return new IntInputer(scan, "input menu", 1, 3).get();
	}

	private void showSemesters() {
		for(int i = 0; i < semesters.size(); i++) {
			Semester s = semesters.elementAt(i);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			System.out.print((i+1) + ". ");
			showSemester(s, format);
			System.out.println("");
		}
		System.out.println("");
	}

	private void showSemester(Semester s, SimpleDateFormat format) {
		System.out.print(s.getLabel());
		System.out.print(" - ");
		System.out.print(format.format(s.getStart()));
		System.out.print(" - ");
		System.out.print(format.format(s.getEnd()));
	}
}
