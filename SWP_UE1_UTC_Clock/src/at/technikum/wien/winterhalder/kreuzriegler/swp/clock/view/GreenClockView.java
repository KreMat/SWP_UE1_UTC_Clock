/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view;

import java.awt.Color;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public class GreenClockView extends AbstractColoredClockView {

	public GreenClockView(Clock clock, int timezone) {
		super(clock, timezone);
		panel.setBackground(Color.GREEN);
	}

}
