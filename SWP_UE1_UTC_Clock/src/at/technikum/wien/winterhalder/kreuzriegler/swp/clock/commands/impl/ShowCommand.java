/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand;
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

	/**
	 * @return the clock
	 */
	public Clock getClock() {
		return clock;
	}

	/**
	 * @param clock
	 *            the clock to set
	 */
	public void setClock(Clock clock) {
		this.clock = clock;
	}

	/**
	 * @return the type
	 */
	public ClockType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(ClockType type) {
		this.type = type;
	}

	/**
	 * @return the timezone
	 */
	public int getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone
	 *            the timezone to set
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
