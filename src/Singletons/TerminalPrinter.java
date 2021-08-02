package Singletons;

import java.util.concurrent.TimeUnit;

public class TerminalPrinter {
	static TerminalPrinter printer = new TerminalPrinter();
	static int numMilSec = 0;
	private TerminalPrinter() {}
	
	public static TerminalPrinter getInstance()
	{
		return printer;
	}
	
	/**
	 * Prints a Welcome Banner to the terminal. 
	 * */
	public static void PrintWelcome()
	{
		String[] lines = {"+--------------------------------+",
				          "|      Welcome To Java Bank      |",
				          "|    Where Java Banks For You    |",
				          "+--------------------------------+"};
		for (int i = 0; i < lines.length; i++) {
			if (i == 0 || i == lines.length - 1) {
				Typer(5, lines[i] + "\n");
				continue;
			}
			Typer(numMilSec, lines[i]+ "\n");
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
	public static void PrintOptions(String prompt, String...options)
	{
		Typer(numMilSec, prompt + "\n");
		
		for (int i = 0; i < options.length; i++) {
			Typer(numMilSec, (i + 1) + ") " + options[i] + "\n");
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
	public static void PrintOptions(int milSecsBetweenChars, String prompt, String...options)
	{
		Typer(milSecsBetweenChars, prompt + "\n");
		
		for (int i = 0; i < options.length; i++) {
			Typer(milSecsBetweenChars, (i + 1) + ") " + options[i] + "\n");
		}
	}
	
	/**
	 * Prints out a single line with typing animation, with BREAK NEW LINE.
	 * @param line - The line that should be printed out.
	 * 
	 * */
	public static void PrintLine(String line)
	{
		Typer(numMilSec, line + "\n");
	}
	
	/**
	 * Prints out a single line with typing animation, with NO BREAK NEW LINE if newlineBreak is set to false.
	 * @param line - The line that should be printed out.
	 * @param newlineBreak - If set to false, it will print the line without a new line break.
	 * 
	 * */
	public static void PrintLine(String line, boolean newlineBreak)
	{
		if (!newlineBreak) {
			Typer(numMilSec, line);
			return;
		}
		PrintLine(line);
	}

	/**
	 * Prints out a single line with typing animation where animation speed is set by "milSecsBetweenChars".
	 * @param milSecsBetweenChars - Wait time between printing each character of the line.
	 * @param line - The line that should be printed out.
	 * 
	 * */
	public static void PrintLine(int milSecsBetweenChars, String line)
	{
		Typer(milSecsBetweenChars, line + "\n");
	}
	
	/**
	 * Prints out a single line with typing animation where animation speed is set by "milSecsBetweenChars".
	 * @param milSecsBetweenChars - Wait time between printing each character of the line.
	 * @param line - The line that should be printed out.
	 * @param newlineBreak - If set to false, it will print the line without a new line break.
	 * 
	 * */
	public static void PrintLine(int milSecsBetweenChars, String line, boolean newlineBreak)
	{
		if (!newlineBreak) {
			Typer(milSecsBetweenChars, line);
			return;
		}
		PrintLine(milSecsBetweenChars, line);
	}
	
	/**
	 * This will clear the console of all texts.
	 * */
	public static void ClearConsole()
	{
		// This is a command that clears the console once it's printed
		System.out.println("\033[H\033[2J");
		System.out.println("\f");
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
	}
}
