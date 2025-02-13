package data_clumps;

import java.util.Date;

public class Semester {
	private String label;
	private Date start;
	private Date end;
	
	public Semester(String label, Date start, Date end) {
		if(start.before(end))
			throw new IllegalArgumentException("start must be before end.");
		this.label = label;
		this.start = start;
		this.end = end;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Date getStart() {
		return start;
	}
	
	public Date getEnd() {
		return end;
	}
}
