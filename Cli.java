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
                System.out.println(myObj);
            } else if (command.equals("time")) {
                LocalTime myObj = LocalTime.now();
                System.out.println(myObj);
            } else if (command.equals("datetime")) {
                LocalDateTime myObj = LocalDateTime.now();
                System.out.println(myObj);
            } else if (command.equals("useraccount")) {
                String username = System.getProperty("user.name");
                System.out.println(username);
            } else if (command.equals("homedirectory")) {
                String userhome = System.getProperty("user.home");
                System.out.println(userhome);
            } else if (command.equals("os")) {
                String osname = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
                System.out.println(osname);
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
