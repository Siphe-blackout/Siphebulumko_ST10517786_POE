import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);

 Registration registration= new Registration();
 registration.Register();

 Login login= new Login(registration.userName, registration.password, registration.firstName, registration.lastName);

 System.out.println("Please login in now");

 //For loop which ensures a maximum of three attempts
  for (int i=0; i<3; i++) {
   System.out.println("Enter Username: ");
   String loginUser= sc.nextLine();
   System.out.println("Enter Password: ");
   String loginPass= sc.nextLine();

   String message= login.loginUser(loginUser,loginPass);
   System.out.println(message);

   //If login is successful, break from loop

   if(message.startsWith("Welcome")){
    break;
   }

   //If this is the third failed attempt, lock the account
   if(i==2){
    System.out.println("Too many failed attempts. Account locked.");
   }
  }
 int choice;

 do {
 System.out.println("\n--- MENU ---");
 System.out.println("1. Send Message");
 System.out.println("2. Disregard Message");
 System.out.println("3. Store Message");
 System.out.println("4. Stored Messages Menu");
 System.out.println("5. Exit");
 choice = sc.nextInt();
 sc.nextLine();

 switch (choice) {
 case 1: handleMessage(sc, "send"); break;
 case 2: handleMessage(sc, "discard"); break;
 case 3: handleMessage(sc, "store"); break;
 case 4: storedMessagesMenu(sc); break;
 case 5: System.out.println("Exiting..."); break;
 default: System.out.println("Invalid choice.");
 }
 } while (choice != 5);
 }

 private static void handleMessage(Scanner sc, String option) {
 System.out.println("Enter Recipient number:");
 String recipient = sc.nextLine();
 System.out.println("Enter Message:");
 String text = sc.nextLine();

 Message msg = new Message(recipient, text);
 System.out.println(msg.sendMessage(option));
System.out.println(msg.printMessage());
 }

 private static void storedMessagesMenu(Scanner sc) {
 System.out.println("\n--- STORED MESSAGES MENU ---");
 System.out.println("1. Display all stored messages");
 System.out.println("2. Display longest stored message");
 System.out.println("3. Search by Message ID");
System.out.println("4. Search by Recipient");
 System.out.println("5. Delete by Hash");
 System.out.println("6. Display full report");

 int option = sc.nextInt();
 sc.nextLine();

 switch (option) {
 case 1: Message.displayStoredMessages(); break;
 case 2: Message.displayLongestMessage(); break;
 case 3:
 System.out.println("Enter Message ID:");
 Message.searchByMessageID(sc.nextLine());
break;
 case 4:
 System.out.println("Enter Recipient:");
 Message.searchByRecipient(sc.nextLine());
 break;
 case 5:
System.out.println("Enter Message Hash:");
 Message.deleteByHash(sc.nextLine());
 break;
 case 6: Message.displayReport(); break;
 default: System.out.println("Invalid option.");
 }
 }
}
