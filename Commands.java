import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.io.File;

public class Commands {


	public static String date(CommandLine commandLine){
		return LocalDate.now().toString();
	}

	public static String time(CommandLine commandLine){
		return LocalTime.now().toString();
	}
	
	public static String datetime(CommandLine commandLine){
		return LocalDateTime.now().toString();
	}

	public static String useraccount(CommandLine commandLine){
		return System.getProperty("user.name");
	}

	public static String userhome(CommandLine commandLine) {
		return System.getProperty("user.home");
	}

	public static String os(CommandLine commandLine) {
		String name = System.getProperty("os.name");
		String version = System.getProperty("os.version"); 
		return name + "(" + version + ")"; 	
	}
	
	public static String printenv (CommandLine commandLine){
		if (commandLine.hasArgument()) {    // The user specified an environment variable to look up
			String variableToLookFor = System.getenv(commandLine.getArguments());
				return variableToLookFor == null ? "" :variableToLookFor;
			

		} else {       // if we did not specify an environment variable, so display all environment variables
			StringBuilder outputBuild = new StringBuilder();
			for (String key : System.getenv().keyset()) {
				outputBuild.append(key)
                                         .append("=")
                                         .append(System.getenv().get(key))
                                         .append(System.lineSeparator());
			
			}
	
			return outputBuild.toString();		
		}
	}	
	
	public static String echo (CommandLine commandLine){
		return commandLine.hasArguments() ? commandLine.getArgument(): "";
	}	

	public static String ls (CommandLine commandLine){
               
		 if (commandLine.hasArgument()) {
                        File currentDir = new File (commandLine.getArguments());
                      
			if (currentDir.exists() && currentDir.isDirectory()) {
				File dir = new File(commandLine.getArgument());	
  				File[] files = dir.listFiles();

                		if (files != null) {
                        		StringBuilder outputBuild  = new StringBuilder();
                        		for (File file : files) {
                                		outputBuild.append(file.getName()).append(System.lineSeparator());
                        		}	
                        		return outputBuild.toString();
                		}	 
                
         	 	}
		}	
		return "Not a directory !";
}
	public static String cat(CommandLine commandLine) {
		if (!commandLine.hasArgument()) {
			return "Please specify a path to a text file to read!";
		}

		File fileAsRead = new File(commandLine.getArgument());

		if (!fileAsRead.exists()) {
			return "Error reading file";
		}
		try (BufferedReader br = new BufferedReader(new FileReader(fileAsRead))) {
			StringBuilder outputBuild = new StringBuilder();
			String line;
			int i = 1;

			while ((line = br.readLine()) != null) {
				outputBuild.append(i + ": " + line + System.lineSeparator());
				i++;
			}
			return outputBuild.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "Error reading file";
		}

	}

	public static String help(CommandLine commandLine) {
		String lineSep = System.lineSeparator();
		if (!commandLine.hasArgument()) {
			return "Command list :" + lineSep +
					" - cat" + lineSep +
					" - date" + lineSep +
					" - datetime" + lineSep +
					" - exit" + lineSep +
					" - echo" + lineSep +
					" - print" + lineSep +
					" - ls" + lineSep +
					" - logout" + lineSep +
					" - os" + lineSep +
					" - printenv" + lineSep +
					" - time" + lineSep +
					" - useraccount" + lineSep +
					" - userhome" + lineSep +
					"Type help 'command' to get instructions !";
		}

		switch (commandLine.getArgument()) {
			case "help":
				return " - with name command :" + lineSep +
						"prints the instructions for the command." + lineSep +
						" - without name command :" + lineSep +
						"prints the command's list.";
			case "cat":
				return "cat 'file name' :" + lineSep + "displays the contents of a text file.";
			case "datetime":
				return "datetime :" + lineSep
						+ "prints the current date and time in format in format '2023-10-12T10:41:39.576986400'.";
			case "exit":
				return "exit :" + lineSep + "quit the program";
			case "echo":
				return "echo 'with text' :" + lineSep + "prints all the arguments passed to the command.";
			case "print":
				return "print 'with text' :" + lineSep
						+ "prints all the arguments passed to the command. This is alias of 'echo'.";
			case "ls":
				return "ls 'directory':" + lineSep +
						"prints the content (only names of files and directory) of a directory." + lineSep +
						"If argument is './', ls prints the content of a current directory.";
			case "logout":
				return "logout :" + lineSep + "quit the program.";
			case "os":
				return "os :" + lineSep + "prints the operating system name and version, example : Windows 10 (10.0).";
			case "printenv":
				return "printenv :" + lineSep +
						" - with name of the environment variable :" + lineSep +
						"prints the value of the specified environment variable." + lineSep +
						" - without name of the environment variable :" + lineSep +
						"prints the value all environment variable.";
			case "time":
				return "time :" + lineSep + "prints the current time in format '10:41:39.576986400'";
			case "useraccount":
				return "useraccount :" + lineSep + "prints the user account name.";
			case "date":
				return "date :" + lineSep + "prints today's date in format '2023-10-12'.";
			case "userhome":
				return "userhome :" + lineSep + "prints the user home directory.";
			default:
				return "'" + commandLine.getArgument() + "' is not command valid !";
		}

	}

} // end of class

