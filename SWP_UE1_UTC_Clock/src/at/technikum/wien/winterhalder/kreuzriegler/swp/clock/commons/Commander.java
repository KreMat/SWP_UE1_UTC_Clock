/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public class Commander {

	private List<ICommand> history = new ArrayList<ICommand>();

	public void storeAndExectue(ICommand c) {
		history.add(c);
		c.execute();
		Clock.getInstance().notifyClockObservers();
	}

	public void undo() {
		if (history.isEmpty()) {
			return;
		}
		history.get(history.size() - 1).undo();
		Clock.getInstance().notifyClockObservers();
	}

	public void redo() {
		if (history.isEmpty()) {
			return;
		}
		history.get(history.size() - 1).execute();
		Clock.getInstance().notifyClockObservers();
	}
}
