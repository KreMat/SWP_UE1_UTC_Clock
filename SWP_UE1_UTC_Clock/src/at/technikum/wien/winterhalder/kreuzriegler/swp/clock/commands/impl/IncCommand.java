package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.AbstractClockChangeCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

public class IncCommand extends AbstractClockChangeCommand {

	public IncCommand(Clock clock, Integer h, Integer m, Integer s) {
		super(clock, h, m, s);
	}

	@Override
	public void execute() {

		saveState();

		if (h != null) {
			clock.setHour(clock.getHour() + h);
		}
		if (m != null) {
			clock.setMinute(clock.getMinute() + m);
		}
		if (s != null) {
			clock.setSecond(clock.getSecond() + s);
		}
	}

}
