/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.test;

import junit.framework.Assert;

import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.DecCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.IncCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ShowCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.ClockType;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.CommandFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.IllegalCommandException;

/**
 * @author Matthias
 * 
 */
public class CommandFactoryTest extends Assert {

	@Test
	public void testShow() throws IllegalCommandException {
		ICommand command = CommandFactory
				.createCommand("show -t red -x 50 -y 40 -z vienna");
		assertTrue(command instanceof ShowCommand);
		ShowCommand shCommand = (ShowCommand) command;
		assertEquals(ClockType.REDCLOCK, shCommand.getType());
		assertEquals(50, shCommand.getX());
		assertEquals(40, shCommand.getY());
		assertEquals(60, shCommand.getTimezone());
	}

	@Test
	public void testInc() throws IllegalCommandException {
		ICommand command = CommandFactory
				.createCommand("inc -h 50 -m 50 -s 40");
		assertTrue(command instanceof IncCommand);
		IncCommand incCommand = (IncCommand) command;
		assertEquals(Integer.valueOf(50), incCommand.getH());
		assertEquals(Integer.valueOf(50), incCommand.getM());
		assertEquals(Integer.valueOf(40), incCommand.getS());
	}

	@Test
	public void testInc2() throws IllegalCommandException {
		ICommand command = CommandFactory.createCommand("inc -h 50 -s 40");
		assertTrue(command instanceof IncCommand);
		IncCommand incCommand = (IncCommand) command;
		assertEquals(Integer.valueOf(50), incCommand.getH());
		assertNull(incCommand.getM());
		assertEquals(Integer.valueOf(40), incCommand.getS());
	}

	@Test
	public void testInc3() throws IllegalCommandException {
		ICommand command = CommandFactory.createCommand("inc");
		assertTrue(command instanceof IncCommand);
		IncCommand incCommand = (IncCommand) command;
		assertNull(incCommand.getH());
		assertNull(incCommand.getM());
		assertNull(incCommand.getS());
	}
	
	@Test
	public void testDec() throws IllegalCommandException {
		ICommand command = CommandFactory
				.createCommand("dec -h 50 -m 50 -s 40");
		assertTrue(command instanceof DecCommand);
		DecCommand decCommand = (DecCommand) command;
		assertEquals(Integer.valueOf(50), decCommand.getH());
		assertEquals(Integer.valueOf(50), decCommand.getM());
		assertEquals(Integer.valueOf(40), decCommand.getS());
	}

	@Test(expected = IllegalCommandException.class)
	public void testCommandInvalid() throws IllegalCommandException {
		CommandFactory.createCommand("dnc");
	}
	
	@Test(expected = IllegalCommandException.class)
	public void testCommandInvalid2() throws IllegalCommandException {
		CommandFactory.createCommand("inc - h 5 0");
	}
	
	@Test(expected = IllegalCommandException.class)
	public void testCommandInvalid3() throws IllegalCommandException {
		CommandFactory.createCommand("inc -h 5 0");
	}

}
