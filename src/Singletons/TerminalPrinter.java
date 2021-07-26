package Singletons;

import java.util.concurrent.TimeUnit;

public class TerminalPrinter {
	static TerminalPrinter printer = new TerminalPrinter();
	
	private TerminalPrinter() {}
	
	public static TerminalPrinter getInstance()
	{
		return printer;
	}
	
	/**
	 * Prints a Welcome Banner to the terminal. 
	 * */
	public void PrintWelcome()
	{
		String[] lines = {"+--------------------------------+",
				          "|      Welcome To Java Bank      |",
				          "|    Where Java Banks For You    |",
				          "+--------------------------------+"};
		for (int i = 0; i < lines.length; i++) {
			if (i == 0 || i == lines.length - 1) {
				Typer(5, lines[i]);
				continue;
			}
			Typer(40, lines[i]);
		}
		System.out.println();
	}
	
	/**
	 * It takes in a single prompt and options and types it to the screen 
	 * with a pause between each character printing to the screen. 40 MilSeconds 
	 * @param prompt - The prompt statement that will be printed to the user
	 * @param options - A list of variables entered in as parameters to the function
	 * 
	 * 		  i.e. PrintOptions("Some Prompt", "Option 1", "Option 2", ..., "Option n")
	 * 
	 */
	public void PrintOptions(String prompt, String...options)
	{
		Typer(40, prompt);
		
		for (int i = 0; i < options.length; i++) {
			Typer(40, (i + 1) + ") " + options[i]);
		}
	}

	/**
	 * It takes in a single prompt and options and types it to the screen 
	 * with a pause between each character printing to the screen.
	 * 
	 * @param milSecsBetweenChars - Milliseconds to wait between each character. 40 Seconds seems to be best
	 * @param prompt - The prompt statement that will be printed to the user
	 * @param options - A list of variables entered in as parameters to the function
	 * 
	 * 		  i.e. PrintOptions("Some Prompt", "Option 1", "Option 2", ..., "Option n")
	 * 
	 */
	public void PrintOptions(int milSecsBetweenChars, String prompt, String...options)
	{
		Typer(milSecsBetweenChars, prompt);
		
		for (int i = 0; i < options.length; i++) {
			Typer(milSecsBetweenChars, (i + 1) + ") " + options[i]);
		}
	}
	
	/**
	 * Prints out a single line with typing animation.
	 * @param line - The line that should be printed out.
	 * 
	 * */
	public void PrintLine(String line)
	{
		Typer(40, line);
	}

	/**
	 * Prints out a single line with typing animation where animation speed is set by "milSecsBetweenChars".
	 * @param milSecsBetweenChars - Wait time between printing each character of the line.
	 * @param line - The line that should be printed out.
	 * 
	 * */
	public void PrintLine(int milSecsBetweenChars, String line)
	{
		Typer(milSecsBetweenChars, line);
	}
	
	private static void Typer(int milSecondsBetweenChars, String line)
	{
		for (int i = 0; i < line.length(); i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(milSecondsBetweenChars);
			} catch (InterruptedException e) {
				System.out.println("Something went wrong...\nRestarting System");
			}
			System.out.print(line.charAt(i));
		}
		System.out.println();
	}
}
