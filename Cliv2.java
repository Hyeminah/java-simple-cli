import java.util.Scanner;

public class Cliv2 {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.print("> ");
	while (true) {
	    CommandLine commandLine = new CommandLine(scanner.nextLine());

	    String command = commandLine.getCommand();

	    String output = "";

	    if (command.equals("exit") || command.equals("logout")) {
		break;

	    } else if (command.equals("date")) {
		output = Commands.date(commandLine); // Get the unformatted date.

	    } else if (command.equals("time")) {
		output = Commands.time(commandLine); // Get the unformatted time.

	    } else if (command.equals("datetime")) {
		output = Commands.datetime(commandLine);

	    } else if (command.equals("useraccount")) {
		output = Commands.useraccount(commandLine);

	    } else if (command.equals("userhome")) {
		output = Commands.userhome(commandLine);

	    } else if (command.equals("os")) {
		output = Commands.os(commandLine);

	    } else if (command.equals("printenv")) {
		output = Commands.printenv(commandLine);

	    } else if (command.equals("echo") || command.equals("print")) {
		output = Commands.echo(commandLine);

	    } else if (command.equals("ls")) {
		output = Commands.ls(commandLine);

	    } else if (command.equals("cat")) {
		output = Commands.cat(commandLine);

	    } else if (command.equals("help")) {
		output = Commands.help(commandLine);

	    } else {
		output = "Command '" + command + "' not found.";
	    }

	    System.out.println(output); // Print with new line (ln)

	    System.out.print("> "); // Prompt
	}
	scanner.close();
	System.out.println("Bye !");

    }

}
