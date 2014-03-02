package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

public class DecCommand extends AbstractClockChangeCommand {

	public DecCommand(Clock clock, Integer h, Integer m, Integer s) {
		super(clock, h, m, s);
	}

	@Override
	public void execute() {
		saveState();

		if (h != null) {
			clock.setHour(clock.getHour() - h);
		}
		if (m != null) {
			clock.setMinute(clock.getMinute() - m);
		}
		if (s != null) {
			clock.setSecond(clock.getSecond() - s);
		}
		
		normalizeClock();

	}

}
