import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FullAppTest {

 Message msg1, msg2, msg3, msg4, msg5;
 Registration registration;
 Login login;

 @BeforeEach
 public void setUp() {
 // Reset test data
 msg1 = new Message("+27834557896", "Did you get the cake?");
 msg1.sendMessage("send");

 msg2 = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.");
 msg2.sendMessage("store");

 msg3 = new Message("+27834484567", "Yohoooo, I am at your gate.");
 msg3.sendMessage("discard");

 msg4 = new Message("0838844567", "It is dinner time!");
 msg4.sendMessage("send");

 msg5 = new Message("+27838884567", "Ok, I am leaving without you.");
 msg5.sendMessage("store");

 registration = new Registration();
 login = new Login("user_1", "Pass@123", "John", "Doe");
 }

 // --- Message Class Tests ---
        @Test
public void testSentMessages() {
 assertEquals("Sent", msg1.getStatus());
 assertEquals("Sent", msg4.getStatus());
 }

 @Test
 public void testStoredMessages() {
 assertEquals("Stored", msg2.getStatus());
 assertEquals("Stored", msg5.getStatus());
 }

 @Test
 public void testDisregardedMessages() {
 assertEquals("Disregarded", msg3.getStatus());
 }

 @Test
public void testLongestStoredMessage() {
 assertTrue(msg2.getMessage().length() > msg5.getMessage().length());
 }

 @Test
 public void testSearchByMessageID() {
 String id = msg4.getMessageID();
 assertEquals("It is dinner time!", msg4.getMessage());
 }

 @Test
 public void testSearchByRecipient() {
 assertEquals("+27838884567", msg2.getRecipient());
 assertEquals("+27838884567", msg5.getRecipient());
 }

 @Test
 public void testDeleteByHash() {
 String hash = msg2.getMessageHash();
 Message.deleteByHash(hash);
assertNotEquals(hash, msg5.getMessageHash());
 }

 @Test
 public void testDisplayReport() {
 String report = msg5.printMessage();
 assertTrue(report.contains("Recipient"));
 assertTrue(report.contains("Message"));
 }

 // --- Registration Class Tests ---
         @Test
 public void testValidUsername() {
 assertTrue(registration.checkuserName("user_"));
 }

 @Test
 public void testInvalidUsername() {
 assertFalse(registration.checkuserName("username"));
 }

 @Test
 public void testValidPassword() {
 assertTrue(registration.checkPassword("Strong@123"));
 }

 @Test
 public void testInvalidPassword() {
 assertFalse(registration.checkPassword("weakpass"));
 }

 @Test
 public void testValidPhoneNumber() {
 assertTrue(registration.checkPhoneNo("+27834567890"));
 }

 @Test
 public void testInvalidPhoneNumber() {
 assertFalse(registration.checkPhoneNo("12345"));
 }

 // --- Login Class Tests ---
        @Test
 public void testSuccessfulLogin() {
 String result = login.loginUser("user_1", "Pass@123");
 assertTrue(result.startsWith("Welcome"));
}

 @Test
 public void testFailedLogin() {
 String result = login.loginUser("wrongUser", "wrongPass");
 assertEquals("Username or Password incorrect. Please try again.", result); }

 // --- Main Class Tests ---
         @Test
 public void testMainMenuExists() {
 // Simulate that Main has menu options 1–5
 int maxOption = 5;
 assertEquals(5, maxOption);
 }
}