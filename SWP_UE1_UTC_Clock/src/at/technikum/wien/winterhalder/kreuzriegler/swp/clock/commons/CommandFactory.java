/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons;

import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.ICommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl.DecCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl.HelpCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl.IncCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl.SetCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl.ShowCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

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

	private static final Clock clock = Clock.getInstance();

	private static final Map<String, Integer> TIMEZONE_MAP = new HashMap<String, Integer>();

	static {
		TIMEZONE_MAP.put("VIENNA", 60);
		TIMEZONE_MAP.put("LONDON", 0);
		TIMEZONE_MAP.put("LA", -8 * 60);
	}

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
				if (keyValue.length == 2) {
					map.put(keyValue[0], keyValue[1]);
				} else {
					throw new IllegalCommandException("Command is not valid");
				}
			}
		}

		switch (map.get(COMMAND)) {
		case "set":
			return new SetCommand(clock, parseWithDefault(map.get(H), null),
					parseWithDefault(map.get(M), null), parseWithDefault(
							map.get(S), null));
		case "inc":
			return new IncCommand(clock, parseWithDefault(map.get(H), null),
					parseWithDefault(map.get(M), null), parseWithDefault(
							map.get(S), null));
		case "dec":
			return new DecCommand(clock, parseWithDefault(map.get(H), null),
					parseWithDefault(map.get(M), null), parseWithDefault(
							map.get(S), null));
		case "show":
			ClockType type = ClockType.getType(map.get(T));
			if (type == null) {
				throw new IllegalCommandException("TYPE: " + map.get(T)
						+ " is not valid");
			}
			int timezone = 0;
			if (map.containsKey(Z)) {
				if (TIMEZONE_MAP.containsKey(map.get(Z).toUpperCase())) {
					timezone = TIMEZONE_MAP.get(map.get(Z).toUpperCase());
				} else {
					throw new IllegalCommandException("TIMZONE " + map.get(Z)
							+ " is not valid!");
				}
			}

			return new ShowCommand(clock, type, timezone, parseWithDefault(
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
