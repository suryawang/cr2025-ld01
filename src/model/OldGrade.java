package model;

public class OldGrade extends Grade {
	public OldGrade(String studentId, int project, int midTerm, int finalTerm) {
		super(studentId, project, midTerm, finalTerm);
	}

	public String getGrade() {
		int total = getTotal();
		if(total >= 85) return "A";
		if(total >= 75) return "B";
		if(total >= 65) return "C";
		if(total >= 50) return "D";
		return "E";
	}
}
