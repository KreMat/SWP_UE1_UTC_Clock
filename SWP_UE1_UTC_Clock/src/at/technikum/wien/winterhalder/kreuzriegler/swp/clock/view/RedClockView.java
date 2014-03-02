/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view;

import java.awt.Color;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author Matthias
 * 
 */
public class RedClockView extends AbstractColoredClockView {

	public RedClockView(Clock clock, int timezone) {
		super(clock, timezone);
		panel.setBackground(Color.RED);
	}

}
