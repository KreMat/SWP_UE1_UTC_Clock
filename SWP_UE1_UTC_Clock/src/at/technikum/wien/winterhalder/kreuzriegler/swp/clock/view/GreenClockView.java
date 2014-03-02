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
public class GreenClockView extends AbstractClockView implements ClockObserver {

	public GreenClockView(Clock clock, ClockType type, int timezone) {
		super(clock, type, timezone);
	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.AbstractClockView#show(int, int)
	 */
	@Override
	public void show(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
