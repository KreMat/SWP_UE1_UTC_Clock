/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.ClockType;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public abstract class AbstractClockView {

	protected Clock clock;
	protected ClockType type;
	protected int timezone;

	public AbstractClockView(Clock clock, ClockType type, int timezone) {
		this.clock = clock;
		this.type = type;
		this.timezone = timezone;
	}
	
	public abstract void show(int x, int y);
}
