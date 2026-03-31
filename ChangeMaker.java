import java.util.Scanner; 

public class ChangeMaker {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      //System.out.printf("Enter total value in cents to change:\n");
      int userInput = sc.nextInt();
      double totalCash = userInput / 100.0;
      int change = userInput;
      //System.out.printf("User input $%.2f.\n", totalCash);
      //System.out.printf("%d cents\n", change);
      int dollars = change / 100;
      change = change - (dollars * 100);
      int quarters = change / 25;
      change = change - (quarters *25);
      //System.out.printf("%d cents remaining\n", change);
      int dimes = change / 10;
      change = change - (dimes * 10);
      //System.out.printf("%d cents remaining\n", change);
      int nickels = change / 5;
      change = change - (nickels * 5);
      //System.out.printf("%d cents remaining\n", change);
      int pennies = change;
      if (dollars > 1){
          System.out.println(dollars + " Dollars");
       }
       else if (dollars == 1) {
          System.out.println(dollars + " Dollar");   
       }
      if (quarters > 1){
         System.out.println(quarters + " Quarters");
      }
      else if (quarters == 1) {
         System.out.println(quarters + " Quarter");   
      }
      if (dimes > 1){
        System.out.println(dimes + " Dimes");
      }
      else if (dimes == 1) {
         System.out.println(dimes + " Dime");   
      }
      if (nickels > 1){
         System.out.println(nickels + " Nickels");
      }
      else if (nickels == 1) {
         System.out.println(nickels + " Nickel");   
      }
      if (pennies > 1){
         System.out.println(pennies + " Pennies");
      }
      else if (pennies == 1) {
         System.out.println(pennies + " Penny");   
      }
      if (userInput == 0) {
    	  System.out.println("No change");
      }
      sc.close();
      }
}
