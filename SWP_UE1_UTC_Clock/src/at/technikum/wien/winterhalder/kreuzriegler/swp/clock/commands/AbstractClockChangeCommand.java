/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

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

	public AbstractClockChangeCommand(Clock clock, Integer h, Integer m,
			Integer s) {
		this.clock = clock;
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
		//Test
	}

	protected void saveState() {
		hOld = clock.getHour();
		mOld = clock.getMinute();
		sOld = clock.getSecond();
	}

	/**
	 * @return the h
	 */
	public Integer getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(Integer h) {
		this.h = h;
	}

	/**
	 * @return the m
	 */
	public Integer getM() {
		return m;
	}

	/**
	 * @param m the m to set
	 */
	public void setM(Integer m) {
		this.m = m;
	}

	/**
	 * @return the s
	 */
	public Integer getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(Integer s) {
		this.s = s;
	}
}
