import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.io.File;

public class Commands {


	public static String date(){
		return LocalDate.now().toString();
	}

	public static String time(){
		return LocalTime.now().toString();
	}
	
	public static String datetime(){
		return LocalDateTime.now().toString();
	}

	public static String useraccount(){
		return System.getProperty("user.name");
	}

	public static String userhome() {
		return System.getProperty("user.home");
	}

	public static String os(){ 
		return System.getProperty("os.name") + " (" + System.getProperty("os.name") + ") "; 	
	}
	
	public static String printenv(CommandLine cmdLine){
		if (cmdLine.hasArgument()) {    // The user specified an environment variable to look up
			String variableToLookFor = System.getenv(cmdLine.getArguments());
			if (variableToLookFor != null) {  // If the variable exists, display its value
				return variableToLookFor;
			
			} else {
				return "";
			}

		} else {       // if we did not specify an environment variable, so display all environment variables
			Map<String, String> env = System.getenv();
			StringBuilder mutable = new StringBuilder();
			for (Map.Entry<String, String> entry : env.entrySet()) {

				 mutable.append(entry.getKey())
                                         .append("=")
                                         .append(entry.getValue())
                                         .append(System.lineSeparator());
			
			}
	
			return mutable.toString();		
		}
	}	
	
	public static String echo (CommandLine cmdLine){
		if (cmdLine.hasArgument()) {
			 return cmdLine.getArguments();
                }
		return "";
	}	

	public static String ls (CommandLine cmdLine){
                if (cmdLine.hasArgument()) {
                        File currentDir = new File (cmdLine.getArguments());
                        File[] files = currentDir.listFiles();

                if (files != null) {
                        StringBuilder sb  = new StringBuilder();
                        for (File file : files) {
                                sb.append(file.getName()).append(System.lineSeparator());
                        }
                                return sb.toString(); // get concatenated string from the StringBuilder
                } else {
                        return "not a directory";
		}
                } else {
                        return "not a directory";
                
                }
		}



} // end of class

