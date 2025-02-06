package report;

import java.io.PrintStream;

public class GradeHtmlView implements ReportView {
	private GradeReport report;
	public GradeHtmlView(GradeReport report) {
		this.report = report;
	}
	
	public void print(PrintStream out) {
		out.println("<!DOCTYPE html><html><body><table border='1'><thead>");
		out.println("<tr><th>StudentId</th><th>Project</th><th>Mid</th>"
				+ "<th>Final</th><th>Total</th><th>Grade</th></tr>");
		out.println("</thead><tbody>");
		for (var grade : report.getData()) {
			out.printf("<tr><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%d</td><td>%s</td></tr>\n",
					grade.getStudentId(), grade.getProject(), grade.getMidTerm(), grade.getFinalTerm(),
					grade.getTotal(), grade.getGrade());
		}
		out.println("</tbody></html>");
	}

}
