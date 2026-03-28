import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.Register();

        Scanner s = new Scanner(System.in);
        System.out.println("Please log in now.");
        System.out.print("Enter Username: ");
        String loginUser = s.nextLine();
        System.out.print("Enter Password: ");
        String loginPass = s.nextLine();

        Login login = new Login(registration.userName, registration.password,
                registration.firstName, registration.lastName);
        System.out.println(login.loginUser(loginUser, loginPass));
    }
}