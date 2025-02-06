import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import report.GradeCsvView;
import report.GradeHtmlView;
import report.GradeReport;
import report.GradeTableView;
import report.ReportView;
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
//		report.print(System.out);
//		report.print(new PrintStream(new FileOutputStream("grade_report.txt")));
//		report.printHtml(System.out);
//		report.printHtml(new PrintStream(new FileOutputStream("grade_report.html")));
		print(new GradeTableView(report),"grade_report.txt");
		print(new GradeHtmlView(report),"grade_report.html");
		print(new GradeCsvView(report),"grade_report.csv");
	}
	static void print(ReportView view, String filename) throws FileNotFoundException {
		view.print(System.out);
		view.print(new PrintStream(new FileOutputStream(filename)));
	}
}
