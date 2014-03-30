/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand;

/**
 * @author Matthias
 * 
 */
public class HelpCommand implements ICommand {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand
	 * #execute()
	 */
	@Override
	public void execute() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				getClass().getResourceAsStream("help.txt")));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			throw new IllegalStateException(e);
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
		System.out.println("Undo the help is not possible!");

	}

}
