/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model;

import java.util.Calendar;
import java.util.TimeZone;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.AbstractSubject;

/**
 * Singleton Clock Model
 * 
 * @author Matthias
 * 
 */
public class Clock extends AbstractSubject {

	private static final Clock singletonInstance = new Clock();

	/**
	 * protected Constructor for singleton needed
	 */
	protected Clock() {
		cal.setLenient(true);
	}

	public static Clock getInstance() {
		return singletonInstance;
	}

	private Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

	/**
	 * @return the hour
	 */
	public int getHour() {
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		cal.set(Calendar.HOUR_OF_DAY, hour);
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return cal.get(Calendar.MINUTE);
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		cal.set(Calendar.MINUTE, minute);
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return cal.get(Calendar.SECOND);
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(int second) {
		cal.set(Calendar.SECOND, second);
	}

}
