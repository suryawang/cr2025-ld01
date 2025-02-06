package report;

import java.io.PrintStream;

public class GradeCsvView implements ReportView {
	private GradeReport report;
	public GradeCsvView(GradeReport report) {
		this.report = report;
	}
	
	public void print(PrintStream out) {
		out.println("StudentId;Project;Mid;Final;Total;Grade");
		for (var grade : report.getData()) {
			out.printf("%s;%s;%d;%d;%d;%s\n",
					grade.getStudentId(), grade.getProject(), grade.getMidTerm(), grade.getFinalTerm(),
					grade.getTotal(), grade.getGrade());
		}
	}

}
