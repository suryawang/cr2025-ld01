package data_clumps;

import java.util.Date;

public class DateRange {
	private Date start;
	private Date end;

	public DateRange(Date start, Date end) {
		if (start.before(end))
			throw new IllegalArgumentException("start must be before end.");
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}
}
