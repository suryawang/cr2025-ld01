package util;

import model.Grade;
import model.NewGrade;
import model.OldGrade;

public final class GradeFactory {
	// function
	public static Grade createGrade(String studentId, String project, String midTerm, String finalTerm) {
		int bin = Integer.parseInt(studentId.substring(0, 2));
		int pro = Integer.parseInt(project);
		int min = Integer.parseInt(midTerm);
		int fin = Integer.parseInt(finalTerm);
		if (bin <= 20)
			return new OldGrade(studentId, pro, min, fin);
		return new NewGrade(studentId, pro, min, fin);
	}
}
