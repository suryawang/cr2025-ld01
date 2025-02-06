import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import report.GradeReport;
//import model.Grade;
import util.GradeFactory;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		var sc = new Scanner(new FileInputStream("grade.csv"));

		var report = new GradeReport();
		sc.nextLine(); // skip header
		while (sc.hasNext()) {
			var line = sc.nextLine();
			var d = line.split("\t");

			var grade = GradeFactory.createGrade(d[0], d[1], d[2], d[3]);
			report.add(grade);
//			System.out.println(grade);
			
		}
		report.print();
	}
}
