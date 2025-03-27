import java.util.Scanner;
import java.io.File;
 
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File deets = new File("accounts.txt");
        //if (deets.exists()) {
            //System.out.println("Kamusta mundo");
        //}
        Scanner reader = new Scanner(deets);
 
 
        System.out.print("Enter username: ");
       
        String username_from_input = scanner.nextLine();
 
        System.out.print("Enter password: ");
       
        String password_from_input = scanner.nextLine();
 
        //System.out.print("username is" + " " + username_from_input);
        //System.out.print("password is" + " " +  password_from_input);

        User me = new User(username_from_input, password_from_input);
       
        boolean accountexists = false;
        while (reader.hasNextLine()) {
            String filedata = reader.nextLine();
            String username_from_file = filedata.split(",")[0];
            String password_from_file = filedata.split(",")[1];
            if (username_from_input.equals(username_from_file) && password_from_input.equals(password_from_file)) {
                accountexists = true;
                break;
            } else {
                continue;
            }
        }
 
        if (accountexists) {
            System.out.println("You have successfully logged in.");
        } else {
            System.out.println("Login unsuccessful.");
        }

        scanner.close();  
        reader.close();
    }
}