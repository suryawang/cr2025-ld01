package model;

public class Grade {
	// fields
	private String studentId;
	private int project;
	private int midTerm;
	private int finalTerm;

	public Grade(String studentId, int project, int midTerm, int finalTerm) {
		this.studentId = studentId;
		this.project = project;
		this.midTerm = midTerm;
		this.finalTerm = finalTerm;
	}

	// methods
	public int getTotal() {
		int total = project * 5 + midTerm * 2 + finalTerm * 3;
		return total / 10 + (total % 10 > 0 ? 1 : 0);
	}

	public String getStudentId() {
		return studentId;
	}

	public int getProject() {
		return project;
	}

	public int getMidTerm() {
		return midTerm;
	}

	public int getFinalTerm() {
		return finalTerm;
	}
	@Override
	public String toString() {
		return String.format("%s => %3d %3d %3d = %3d", 
				studentId, project, midTerm, finalTerm, getTotal());
	}
}
