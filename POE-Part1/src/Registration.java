import java.util.Scanner;

public class Registration {
    String userName;
    String password;
    String phoneNo;

    public boolean checkuserName(String userName){
        return !userName.contains("_")&&userName.indexOf("_")> 5;
    } //checks password
    public boolean checkpassword(String password){
        return password.length()< 8||
                !password.matches(".*[A-Z]*.") ||
                !password.matches(".*[0-9]*.") ||
                !password.matches(".*[!@#$%^&*()_+<>~`]*.");
    }
    public boolean checkphoneNo(String phoneNo){
        return !phoneNo.matches("(\\+27|0)[0-9]{9}");
    }
    public void Register(){
        Scanner s= new Scanner(System.in);
        do{
            System.out.println("Enter Username.");
            userName= s.nextLine();
            if(checkuserName(userName)){
                System.out.println("Invalid Username. Try again.");
            }
        }while(checkuserName(userName));
        do{
            System.out.println("Enter phone number.");
            phoneNo=s.nextLine();
            if(checkphoneNo(phoneNo)){
                System.out.println("Invalid phone number. Try again.");
            }
        }while(checkphoneNo(phoneNo));
        do{
            System.out.println("Enter password");
            password=s.nextLine();
            if(!checkpassword(password)){
                System.out.println("Invalid password. Try again");
            }
        }while(!checkpassword(password));
    }
}
