package report;

import java.io.PrintStream;
import java.util.List;
import java.util.Vector;

import model.Grade;

public class GradeReport {
	private List<Grade> data = new Vector<>();
	public void add(Grade item) {
		data.add(item);
	}
	public void print(PrintStream out) {
		out.println("+-----------+---------+-----+-------+-------+-------+");
		out.println("| StudentId | Project | Mid | Final | Total | Grade |");
		out.println("+-----------+---------+-----+-------+-------+-------+");
		for (var grade : data) {
			out.printf ("| %-8s  |   %3s   | %3d |  %3d  |  %3d  |   %-2s  |\n",
					grade.getStudentId(), grade.getProject(), grade.getMidTerm(),
					grade.getFinalTerm(), grade.getTotal(), grade.getGrade());
		}
		out.println("+-----------+---------+-----+-------+-------+-------+");
	}
}
