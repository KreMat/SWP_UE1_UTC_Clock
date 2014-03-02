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
public class BlueClockView extends AbstractColoredClockView {

	public BlueClockView(Clock clock, int timezone) {
		super(clock, timezone);
		panel.setBackground(Color.BLUE);
	}

}
