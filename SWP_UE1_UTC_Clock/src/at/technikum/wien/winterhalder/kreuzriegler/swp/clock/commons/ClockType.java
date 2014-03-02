/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons;

/**
 * @author richie
 *
 */
public enum ClockType {
	GREENCLOCK("green"), REDCLOCK("red");
	
	private String name;
	
	private ClockType(String name){
		this.name = name;
	}

	public static ClockType getType(String type) {
		for(ClockType c : ClockType.values()){
			if(c.name.equals(type)){
				return c;
			}
		}
		return null;
	}
}
