package at.technikum.wien.winterhalder.kreuzriegler.swp.clock;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands.impl.IncCommand;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.CommandFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.Commander;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.IllegalCommandException;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

public class ApplicationMain {

	private static final String REDO = "redo";
	private static final String UNDO = "undo";
	private static final String QUIT = "quit";

	public static void main(String[] args) {

		final Clock clock = Clock.getInstance();

		Timer timer = new Timer();

		final IncCommand inc = new IncCommand(clock, null, null, 1);

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				inc.execute();
				clock.notifyClockObservers();
			}
		}, 0, 1000);

		final Commander comm = new Commander();
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		try {
			while (true) {
				System.out.println("Your Command please: ");
				String line = sc.nextLine();
				switch (line) {
				case QUIT:
					System.exit(0);
				case UNDO:
					comm.undo();
					continue;
				case REDO:
					comm.redo();
					continue;
				}
				try {
					comm.storeAndExectue(CommandFactory.createCommand(line));
				} catch (IllegalCommandException e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
