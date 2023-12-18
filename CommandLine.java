public class CommandLine {

    private String command;
    private String argument;

    CommandLine(String commandExtract) {
	String[] commandArgs = commandExtract.trim().split(" ", 2);
	command = commandArgs[0].trim();
	if (commandArgs.length > 1) {
	    argument = commandArgs[1].trim();

	}
    }

    public String getCommand() {
	return command;
    }

    public String getArgument() {
	return argument;
    }

    public boolean hasArgument() {
	return argument != null;
    }

}
