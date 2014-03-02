/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public abstract class AbstractClockView implements ClockObserver {

	protected Clock clock;
	protected int timezone;

	public AbstractClockView(Clock clock, int timezone) {
		this.clock = clock;
		this.timezone = timezone;
	}

	public abstract void show(int x, int y);
	
	public abstract void close();
}
