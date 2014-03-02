/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.ClockObserver;

/**
 * @author richie
 * 
 */
public abstract class AbstractSubject {
	
	private List<ClockObserver> observers = new ArrayList<ClockObserver>();
	
	public void add(ClockObserver o) {
		observers.add(o);
	}
	
	public void remove(ClockObserver o){
		observers.remove(o);
	} 
	
	public void notifyClockObservers(){
		for(ClockObserver o : observers){
			o.update();
		}
	}
}
