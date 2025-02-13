package data_clumps;

import java.util.Date;

public class Semester {
	private String label;
	private DateRange range;
	
	public Semester(String label, Date start, Date end) {
		this.label = label;
		this.range = new DateRange(start, end);
	}
	
	public String getLabel() {
		return label;
	}
	
	public Date getStart() {
		return range.getStart();
	}
	
	public Date getEnd() {
		return range.getEnd();
	}
}
