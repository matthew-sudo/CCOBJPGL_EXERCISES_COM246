//import java.util.Scanner;
//import java.io.File;
 
public class App {
    public static void main(String[] args) throws Exception {
        //Scanner scanner = new Scanner(System.in);

            DataScientist employee1 = new DataScientist("John");
            Researcher employee2 = new Researcher("Jane");
            
            System.out.println(employee1.getName() + " works as a " + employee1.getWork() + " and he earns " + employee1.getSalary());
            System.out.println(employee2.getName() + " works as a " + employee2.getWork() + " and she earns " + employee2.getSalary());

            Hybrid mycar = new Hybrid();

            System.out.println("My car has " + mycar.getCylindersCount() + " cylinders and " + mycar.getBatteryCount() + " battery.");

            
    }
}

        //File deets = new File("accounts.txt");
        //if (deets.exists()) {
            //System.out.println("Kamusta mundo");
        //}
        //Scanner reader = new Scanner(deets);
 
 
        //System.out.print("Enter username: ");
       
        //String username_from_input = scanner.nextLine();
 
        //System.out.print("Enter password: ");
       
        //String password_from_input = scanner.nextLine();
 
        //System.out.print("username is" + " " + username_from_input);
        //System.out.print("password is" + " " +  password_from_input);

        //User me = new User(username_from_input, password_from_input);
       
        //boolean accountexists = false;
        //while (reader.hasNextLine()) {
           // String filedata = reader.nextLine();
            //String username_from_file = filedata.split(",")[0];
            //String password_from_file = filedata.split(",")[1];
            //if (username_from_input.equals(username_from_file) && password_from_input.equals(password_from_file)) {
                //accountexists = true;
                //break;
            //} else {
                //continue;
            //}
        //}
 
        //if (accountexists) {
            //System.out.println("You have successfully logged in.");
        //} else {
            //System.out.println("Login unsuccessful.");
        //}

        //scanner.close();  
        //reader.close();
// }
//}