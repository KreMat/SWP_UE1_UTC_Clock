/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.ClockType;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.AbstractClockView;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.GreenClockView;

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

	public ShowCommand(ClockType type, int timezone, int x, int y) {
		this.clock = Clock.getInstance();
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
