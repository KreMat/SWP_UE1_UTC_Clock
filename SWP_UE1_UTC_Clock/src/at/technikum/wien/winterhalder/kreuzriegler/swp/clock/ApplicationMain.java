package at.technikum.wien.winterhalder.kreuzriegler.swp.clock;

import java.io.InputStreamReader;
import java.util.Scanner;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.CommandFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commons.Commander;

public class ApplicationMain {

	public static void main(String[] args) {

		//TODO undo, redo, help, timezone, mehrer Types
		Commander comm = new Commander();
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		boolean nextCommand = true;

		while (nextCommand) {
			System.out.println("Your Command please: ");
			comm.storeAndExectue(CommandFactory.createCommand(sc.nextLine()));
		}
		sc.close();
	}

}
