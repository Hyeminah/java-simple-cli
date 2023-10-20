import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.io.File;

public class Cliv2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> ");
		while (true) {
			String command = scanner.nextLine();
			String output = "";
			String[] commandArgs =command.trim().split(" ",2); // for split the string in two and trim

			if (command.equals("exit")||command.equals("logout")) {
				break;
			}

			if (command.equals("date")) {
				LocalDate myObj = LocalDate.now();
				output = myObj.toString(); // Get the unformatted date.
			} 
			else if (command.equals("time")) {
				LocalTime myObj = LocalTime.now();
				output = myObj.toString(); // Get the unformatted time.
			}
			else if (command.equals("datetime")) {
				LocalDateTime myObj = LocalDateTime.now();
				output = myObj.toString();
			}
			else if (command.equals("useraccount")) {
				String username = System.getProperty("user.name");
				output = username;
			}
			else if (command.equals("userhome")) {
				String homedirectory = System.getProperty("user.home");
				output = homedirectory;
			}
			else if (command.equals("os")) {
				String osname = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
				output = osname;
			} 
			else if (commandArgs[0].equals("printenv")) {
				if (commandArgs.length > 1) { 	 // The user specified an environment variable to look up
					String variableToLookFor = System.getenv(commandArgs[1]);
					if (variableToLookFor != null) {  // If the variable exists, display its value
						output = variableToLookFor;
					}
				} 
				else {       // if we did not specify an environment variable, so display all environment variables
					Map<String, String> env = System.getenv();
					StringBuilder mutable = new StringBuilder();
					for (Map.Entry<String, String> entry : env.entrySet()) {

					mutable.append(entry.getKey())
              				 .append("=")
              				 .append(entry.getValue())
              				 .append(System.lineSeparator());
       					 //Format like "variable_name = variable_value" and add a newline(/n doesn't work for every OS)
    				}

   					 output = mutable.toString();
					}
					  
				}
			
			else if (commandArgs[0].equals("echo")|| commandArgs[0].equals("print")) { 
				// take the same array for the same position for call echo, second time for change echo and print
				if (commandArgs.length > 1) {
					output = commandArgs[1];
				}
			}
			else if (commandArgs[0].equals("ls")) {   // Check if the user entered "ls" to list files and directories in the current directory.
				if (commandArgs.length > 1) {
					File currentDir = new File (commandArgs[1]);
					File[] files = currentDir.listFiles();

 					if (files != null) {
						for (File file : files) {
							output += file.getName() + System.lineSeparator();
				
						}
					}
					else {
						output = "not a directory";
					}
				} 
				else {
					output = "not a directory";
				}
			}
			else {
				output = "Command '" + commandArgs[0] + "' not found.";
			}
	
			System.out.println(output);
			System.out.print("> ");
		}
		scanner.close();
		System.out.println("Bye!");
	}
}

