import java.util.Scanner;

public class LeapYear {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int inputYear;
      boolean isLeapYear;
      
      isLeapYear = false;
      inputYear = scnr.nextInt();
      
      if ((inputYear % 400) == 0) {
         isLeapYear = true;
      }
      else if (((inputYear % 4) == 0) && ((inputYear % 100) != 0)) {
         isLeapYear = true;
      }
      
      if (isLeapYear == true){
    	  System.out.printf("%d is a leap year.\n", inputYear);
      }
      else {
    	  System.out.printf("%d is not a leap year.\n", inputYear);
      }
      //1712 is a leap year. 
      scnr.close();
   }
}
