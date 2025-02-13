package data_clumps;

import java.util.Date;

public class Kelas {
	private String course;
	private DateRange range;

	public Kelas(String course, Date start, Date end) {
		this.course = course;
		this.range = new DateRange(start, end);
	}

	public Date getStart() {
		return range.getStart();
	}

	public Date getEnd() {
		return range.getEnd();
	}

	public String getCourse() {
		return course;
	}
}
