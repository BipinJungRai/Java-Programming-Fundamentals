package exercise1;

import java.text.DecimalFormat;

public class ClockDisplay {
	private NumberInfo hours, minutes;
	private boolean type; //If type is True, 12, if type is false, display 24hr format.
	
	public ClockDisplay(boolean type) {
		super();
		this.hours = new NumberInfo(24);
		this.minutes = new NumberInfo(60);
		this.type = type;
	}
	
	public void timeTick() {
		minutes.increment();
		
		if(minutes.getValue() == 0) {
			hours.increment();
		}
	}

	@Override
	public String toString() {
		DecimalFormat style24 = new DecimalFormat("00");
		DecimalFormat style12 = new DecimalFormat("0");
		
		if (type == true) {
			if (hours.getValue() > 12) {
				return ( style12.format(this.hours.getValue() - 12)  +
						":" + style24.format(this.minutes.getValue()) + "pm");
			}
			if (hours.getValue() < 12) {
				return ( style12.format(this.hours.getValue())  +
						":" + style24.format(this.minutes.getValue()) + "am");
			}
			if (hours.getValue() == 12) {
				return ( style24.format(this.hours.getValue())  +
						":" + style24.format(this.minutes.getValue()) + "pm");
			}
		if (type == false) {
			return ( style24.format(this.hours.getValue()) +
					":" + style24.format(this.minutes.getValue()) );
		}
		return null;
	}
}
}
