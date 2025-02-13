package data_clumps;

import java.util.Date;

public class Kelas {
	private String course;
	private Date start;
	private Date end;

	public Kelas(String course, Date start, Date end) {
		if (start.before(end))
			throw new IllegalArgumentException("start must be before end.");
		this.course = course;
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public String getCourse() {
		return course;
	}
}
