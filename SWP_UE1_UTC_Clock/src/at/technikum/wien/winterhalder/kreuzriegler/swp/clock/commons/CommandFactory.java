/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons;

import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.DecCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.HelpCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.IncCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.SetCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ShowCommand;

/**
 * @author richie
 * 
 */
public class CommandFactory {

	private static final String Y = "y";
	private static final String X = "x";
	private static final String Z = "z";
	private static final String T = "t";
	private static final String S = "s";
	private static final String M = "m";
	private static final String H = "h";
	private static final String COMMAND = "command";

	public static ICommand createCommand(String input)
			throws IllegalCommandException {

		Map<String, String> map = new HashMap<String, String>();
		int whiteSpaceIndex = input.indexOf(" ");

		if (whiteSpaceIndex == -1) {
			map.put(COMMAND, input);
		} else {
			map.put(COMMAND, input.substring(0, whiteSpaceIndex));
			String[] splittedInput = input.substring(whiteSpaceIndex + 1)
					.split("-");

			for (int i = 1; i < splittedInput.length; i++) {
				String[] keyValue = splittedInput[i].split(" ");
				map.put(keyValue[0], keyValue[1]);
			}
		}

		switch (map.get(COMMAND)) {
		case "set":
			return new SetCommand(parseWithDefault(map.get(H), null),
					parseWithDefault(map.get(M), null), parseWithDefault(
							map.get(S), null));
		case "inc":
			return new IncCommand(parseWithDefault(map.get(H), null),
					parseWithDefault(map.get(M), null), parseWithDefault(
							map.get(S), null));
		case "dec":
			return new DecCommand(parseWithDefault(map.get(H), null),
					parseWithDefault(map.get(M), null), parseWithDefault(
							map.get(S), null));
		case "show":
			return new ShowCommand(ClockType.getType(map.get(T)),
					parseWithDefault(map.get(Z), 0), parseWithDefault(
							map.get(X), 0), parseWithDefault(map.get(Y), 0));
		case "help":
			return new HelpCommand();
		}

		throw new IllegalCommandException("Command: " + input + " is invalid!");
	}

	private static Integer parseWithDefault(String number, Integer defaultVal) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}
}
