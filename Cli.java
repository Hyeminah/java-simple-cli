import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (true) {
            String command = scanner.nextLine();
            String output = "";

            if (command.equals("exit")) {
                break;
            }

            if (command.equals("date")) {
                LocalDate myObj = LocalDate.now();
                output = myObj.toString(); // Get the unformatted date.
				
            } else if (command.equals("time")) {
                LocalTime myObj = LocalTime.now();
                output = myObj.toString(); // Get the unformatted time.

            } else if (command.equals("datetime")) {
                LocalDateTime myObj = LocalDateTime.now();
                 output = myObj.toString();

            } else if (command.equals("useraccount")) {
                String username = System.getProperty("user.name");
                output = (username);

            } else if (command.equals("userhome")) {
                String homedirectory = System.getProperty("user.home");
                output = (homedirectory);

            } else if (command.equals("os")) {
                String osname = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
                output = (osname);

		} else if (command.startsWith("printenv ")) {
   		 String[] commandArgs = command.split(" ");
     
	      if (commandArgs.length > 1) {
       		 String variableToLookFor =System.getenv(commandArgs[1]);
	
       		 if (variableToLookFor != null) {
           	 output = commandArgs[1];
       
		 } else {
        	 output = "Name variable is not correct";
       		 }
    } else {
        output = "Name variable is not defined";
    }
		 } else {
                output = "Command '" + command + "' not found.";
            }
        
            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Bye!");
    }
}
