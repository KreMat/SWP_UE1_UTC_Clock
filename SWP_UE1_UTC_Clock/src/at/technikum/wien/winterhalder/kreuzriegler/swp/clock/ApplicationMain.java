package at.technikum.wien.winterhalder.kreuzriegler.swp.clock;

import java.io.InputStreamReader;
import java.util.Scanner;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.CommandFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.Commander;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.IllegalCommandException;

public class ApplicationMain {

	public static void main(String[] args) {

		final Commander comm = new Commander();
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		boolean nextCommand = true;

		while (nextCommand) {
			System.out.println("Your Command please: ");
			String line = sc.nextLine();
			switch (line) {
			case "quit":
				nextCommand = false;
				continue;
			case "undo":
				comm.undo();
				continue;
			case "redo":
				comm.redo();
				continue;
			}
			try {
				comm.storeAndExectue(CommandFactory.createCommand(line));
			} catch (IllegalCommandException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}

}
