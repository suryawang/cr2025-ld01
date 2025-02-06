package model;

public class NewGrade extends Grade {
	public NewGrade(String studentId, int project, int midTerm, int finalTerm) {
		super(studentId, project, midTerm, finalTerm);
	}

	public String getGrade() {
		int total = getTotal();
		if(total >= 90) return "A";
		if(total >= 85) return "A-";
		if(total >= 80) return "B+";
		if(total >= 75) return "B";
		if(total >= 70) return "B-";
		if(total >= 65) return "C";
		if(total >= 50) return "D";
		return "E";
	}
}
