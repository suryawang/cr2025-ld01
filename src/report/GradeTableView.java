package report;

import java.io.PrintStream;

public class GradeTableView implements ReportView {
	private GradeReport report;
	public GradeTableView(GradeReport report) {
		this.report = report;
	}
	
	public void print(PrintStream out) {
		out.println("+-----------+---------+-----+-------+-------+-------+");
		out.println("| StudentId | Project | Mid | Final | Total | Grade |");
		out.println("+-----------+---------+-----+-------+-------+-------+");
		for (var grade : report.getData()) {
			out.printf ("| %-8s  |   %3s   | %3d |  %3d  |  %3d  |   %-2s  |\n",
					grade.getStudentId(), grade.getProject(), grade.getMidTerm(),
					grade.getFinalTerm(), grade.getTotal(), grade.getGrade());
		}
		out.println("+-----------+---------+-----+-------+-------+-------+");
	}

}
