/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.ClockType;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.AbstractClockView;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.BlueClockView;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.GreenClockView;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.RedClockView;

/**
 * @author richie
 * 
 */
public class ShowCommand implements ICommand {

	private Clock clock;
	private ClockType type;
	private int timezone;
	private int x;
	private int y;
	private AbstractClockView view;

	public ShowCommand(Clock clock, ClockType type, int timezone, int x, int y) {
		this.clock = clock;
		this.type = type;
		this.timezone = timezone;
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand
	 * #execute()
	 */
	@Override
	public void execute() {
		if (type == null) {
			view = new GreenClockView(clock, timezone);
			view.show(x, y);
			clock.add(view);
		} else {
			switch (type) {
			case GREENCLOCK:
				view = new GreenClockView(clock, timezone);
				view.show(x, y);
				clock.add(view);
				break;
			case REDCLOCK:
				view = new RedClockView(clock, timezone);
				view.show(x, y);
				clock.add(view);
				break;
			case BLUECLOCK:
				view = new BlueClockView(clock, timezone);
				view.show(x, y);
				clock.add(view);
				break;
			default:
				throw new IllegalStateException("TYPE: " + type + " not valid!");
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand
	 * #undo()
	 */
	@Override
	public void undo() {
		view.close();
	}

}
