/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.ClockType;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

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
	
	public ShowCommand(Clock clock, ClockType type, int timezone, int x, int y) {
		this.clock = clock;
		this.type = type;
		this.timezone = timezone;
		this.x = x;
		this.y = y;
	}
	
	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
