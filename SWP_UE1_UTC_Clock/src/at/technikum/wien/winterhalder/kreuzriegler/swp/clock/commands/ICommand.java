package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.commands;

public interface ICommand {
	public void execute();

	// TODO FRAGE Was passiert bei einem wiederholten UNDO????
	public void undo();
}
