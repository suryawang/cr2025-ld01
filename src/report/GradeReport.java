package report;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import model.Grade;

public class GradeReport {
	private List<Grade> data = new Vector<>();

	public void add(Grade item) {
		data.add(item);
	}
	public List<Grade> getData() {
		return Collections.unmodifiableList(data);
	}

//	public void print(PrintStream out) {
//		out.println("+-----------+---------+-----+-------+-------+-------+");
//		out.println("| StudentId | Project | Mid | Final | Total | Grade |");
//		out.println("+-----------+---------+-----+-------+-------+-------+");
//		for (var grade : data) {
//			out.printf("| %-8s  |   %3s   | %3d |  %3d  |  %3d  |   %-2s  |\n", grade.getStudentId(),
//					grade.getProject(), grade.getMidTerm(), grade.getFinalTerm(), grade.getTotal(), grade.getGrade());
//		}
//		out.println("+-----------+---------+-----+-------+-------+-------+");
//	}
//
//	public void printHtml(PrintStream out) {
//		out.println("<!DOCTYPE html><html><body><table border='1'><thead>");
//		out.println("<tr><th>StudentId</th><th>Project</th><th>Mid</th>"
//				+ "<th>Final</th><th>Total</th><th>Grade</th></tr>");
//		out.println("</thead><tbody>");
//		for (var grade : data) {
//			out.printf("<tr><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%d</td><td>%s</td></tr>\n",
//					grade.getStudentId(), grade.getProject(), grade.getMidTerm(), grade.getFinalTerm(),
//					grade.getTotal(), grade.getGrade());
//		}
//		out.println("</tbody></html>");
//	}
}
