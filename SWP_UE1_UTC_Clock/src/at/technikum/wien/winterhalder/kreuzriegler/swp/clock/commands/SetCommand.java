package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;


/**
 * @author richie
 *
 */
public class SetCommand extends AbstractClockChangeCommand {

	public SetCommand(Integer h, Integer m, Integer s) {
		super(h, m, s);
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
		
		normalizeClock();
	}

}
