/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

import java.util.Calendar;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public abstract class AbstractClockChangeCommand implements ICommand {

	protected Clock clock;
	protected Integer h;
	protected Integer m;
	protected Integer s;
	protected Integer hOld;
	protected Integer mOld;
	protected Integer sOld;

	public AbstractClockChangeCommand(Integer h, Integer m, Integer s) {
		this.clock = Clock.getInstance();
		this.h = h;
		this.m = m;
		this.s = s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand
	 * #execute()
	 */
	@Override
	public abstract void execute();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand
	 * #undo()
	 */
	@Override
	public void undo() {

		if (hOld != null) {
			clock.setHour(hOld);
		}
		if (mOld != null) {
			clock.setMinute(mOld);
		}
		if (sOld != null) {
			clock.setSecond(sOld);
		}
	}

	protected void saveState() {
		hOld = clock.getHour();
		mOld = clock.getMinute();
		sOld = clock.getSecond();
	}

	protected void normalizeClock() {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(true);
		
		cal.set(Calendar.HOUR_OF_DAY, clock.getHour());
		cal.set(Calendar.MINUTE, clock.getMinute());
		cal.set(Calendar.SECOND, clock.getSecond());
		
		clock.setHour(cal.get(Calendar.HOUR_OF_DAY));
		clock.setMinute(cal.get(Calendar.MINUTE));
		clock.setSecond(cal.get(Calendar.SECOND));
	}

}
