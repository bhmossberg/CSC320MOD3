import java.util.Scanner; 

public class NameFormat {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String fullName = sc.nextLine().trim();
      String[] names = fullName.split("\\s+");
      String firstName = "";
      String middleName = "";
      String lastName = "";
      String nameOutput = "";
      String middleInitial = "";
      
      if (names.length == 2) {
    	  firstName = names[0]; 
          lastName = names[1]; 
          System.out.printf("%s, %s\n", lastName, firstName);
      }
      else if (names.length == 3) {
         firstName = names[0]; 
         middleName = names[1]; 
         lastName = names[2];
         middleInitial = middleName.substring(0, 1);
         System.out.printf("%s, %s %s.\n", lastName, firstName, middleInitial);
      }
      else {
    	  System.out.print("Invalid input, must enter at least two names.");
      }
      
      
      //System.out.println(firstName);
      //System.out.println(middleName);
      //System.out.println(lastName);
      //System.out.println(middleInitial);
      

      
   }
}
