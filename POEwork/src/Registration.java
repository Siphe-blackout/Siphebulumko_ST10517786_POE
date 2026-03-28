import java.util.Scanner;

public class Registration {
    String userName;
    String password;
    String phoneNo;
    String firstName;
    String lastName;

    //Sets and checks conditions for Username-must be less that or equal to 5 characters and contain "_"
    public boolean checkuserName(String userName){
        return userName.length()<=5 && userName.contains("_");
    }

    //Sets and checks conditions for Password-must be at least 8 chars,can con tain upper class,digit or special chars
    public boolean checkPassword(String password){
        if(password.length()<8){
            return false;
        }
        boolean hadUppercase= false;
        boolean hasSpecial= false;

        for (int i=0; i<password.length(); i++){
            char ch = password.charAt(i);

            if(Character.isUpperCase(ch)){
                hadUppercase= true;
            }
            if(!Character.isLetterOrDigit(ch)){
                hasSpecial=true;
            }
        } return hadUppercase&&hasSpecial;
    }
    //Sets and checks conditions for Phone number-must start with +27 or 0 and must have 9 digits after
    public boolean checkPhoneNo(String phoneNo){
        return phoneNo.matches("(\\+27|0)[0-9]{9}");
    }

    public void Register(){
       Scanner s= new Scanner(System.in);
        //Enter user First and Last names
        System.out.println("Enter First Name");
        firstName=s.nextLine();
        System.out.println("Enter Last Name");
        lastName=s.nextLine();

       //Username
        do{
            System.out.println("Enter Username");
            userName=s.nextLine();
            if(!checkuserName(userName)){
                System.out.println("Invalid Username. Try again.");
            }
        }while(!checkuserName(userName));

        //Phone number
        do{
            System.out.println("Enter Phone number");
            phoneNo=s.nextLine();
            if(!checkPhoneNo(phoneNo)){
                System.out.println("Invalid Phone Number. Try again.");
            }
        }while(!checkPhoneNo(phoneNo));

        //Password
        while(true){
            System.out.println("Enter password");
            password=s.nextLine();

            if(checkPassword(password)){
                break;
            }
            else{
                System.out.println("Incorrect password.");
                System.out.println("Password should contain a Capital letter,Special character or digits.");
            }

        }

        //When user inserts all correct information
        System.out.println("Registration Successful");

        Login login= new Login(userName,password,"Siphebulumko","Somana");
        login.loginUser(userName,password);

        // Capture and print the login result
        String loginResult = login.loginUser(userName, password);
        System.out.println(loginResult);




    }

}
