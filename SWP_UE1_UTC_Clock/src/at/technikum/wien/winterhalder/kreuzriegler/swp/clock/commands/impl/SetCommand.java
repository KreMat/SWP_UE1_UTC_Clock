package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.AbstractClockChangeCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public class SetCommand extends AbstractClockChangeCommand {

	public SetCommand(Clock clock, Integer h, Integer m, Integer s) {
		super(clock, h, m, s);
	}

	@Override
	public void execute() {

		saveState();

		if (h != null) {
			clock.setHour(h);
		}
		if (m != null) {
			clock.setMinute(m);
		}
		if (s != null) {
			clock.setSecond(s);
		}

	}

}
