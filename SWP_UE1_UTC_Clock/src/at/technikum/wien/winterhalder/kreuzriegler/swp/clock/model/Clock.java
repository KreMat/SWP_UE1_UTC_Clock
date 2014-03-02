/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model;

/**
 * Singleton Clock Model
 * 
 * @author Matthias
 * 
 */
public class Clock {

	private static Clock singletonInstance = new Clock();

	/**
	 * protected Constructor for singleton needed
	 */
	protected Clock() {

	}

	public static Clock getInstance() {
		return singletonInstance;
	}

	private int hour = 0;

	private int minute = 0;

	private int second = 0;

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}

}
