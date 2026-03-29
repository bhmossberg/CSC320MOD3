import java.util.Scanner;

public class AverageWitholdingMarginal {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        double income = 0.0;
        boolean validInput = false;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        
        // Input validation loop (max 3 attempts)
        while (attempts < MAX_ATTEMPTS && !validInput) {
            System.out.println("Enter your annual salary:");
            String input = scnr.nextLine().trim();
            
            try {
                income = Double.parseDouble(input);
                if (income >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Salary must be positive. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number.");
            }
            
            if (!validInput) {
                attempts++;
            }
        }
        
        if (validInput) {
            System.out.printf("You entered $%.2f.%n", income);
            
            double bracket1Tax = 0.0;   // 10% bracket (0 - 499.99)
            double bracket2Tax = 0.0;   // 15% bracket (500 - 1499.99)
            double bracket3Tax = 0.0;   // 20% bracket (1500 - 2499.99)
            double bracket4Tax = 0.0;   // 30% bracket (2500+)
            int marginalBracket = 0;
            
            // Progressive (marginal) tax calculation
            if (income >= 2500) {
                bracket1Tax = 499.99;
                bracket2Tax = 1000.00;
                bracket3Tax = 1000.00;
                bracket4Tax = income - 2499.99;
                marginalBracket = 30;
            } 
            else if (income >= 1500) {
                bracket1Tax = 499.99;
                bracket2Tax = 1000.00;
                bracket3Tax = income - 1499.99;
                marginalBracket = 20;
            } 
            else if (income >= 500) {
                bracket1Tax = 499.99;
                bracket2Tax = income - 499.99;
                marginalBracket = 15;
            } 
            else {
                bracket1Tax = income;
                marginalBracket = 10;
            }
            
            /* Test code for  taxable income per bracket
            System.out.printf("Total taxable income = $%.2f%n", (bracket1Tax + bracket2Tax + bracket3Tax + bracket4Tax));
            System.out.printf("Taxable income at 10%%: $%.2f%n", bracket1Tax);
            System.out.printf("Taxable income at 15%%: $%.2f%n", bracket2Tax);
            System.out.printf("Taxable income at 20%%: $%.2f%n", bracket3Tax);
            System.out.printf("Taxable income at 30%%: $%.2f%n", bracket4Tax);
            */
            
            // Convert taxable income to actual tax per bracket
            bracket1Tax *= 0.10;
            bracket2Tax *= 0.15;
            bracket3Tax *= 0.20;
            bracket4Tax *= 0.30;
            
            // Final calculations
            double totalIncomeTax = bracket1Tax + bracket2Tax + bracket3Tax + bracket4Tax;
            double averageTaxRate = totalIncomeTax / income;
            double weeklyIncomeTax = totalIncomeTax / 52.0;
            
            System.out.printf("Marginal tax rate: %d%%%n", marginalBracket);
            System.out.printf("Average tax rate: %.2f%%%n", averageTaxRate * 100);
            System.out.printf("Total annual tax burden: $%.2f%n", totalIncomeTax);
            System.out.printf("Average weekly tax withholding: $%.2f%n", weeklyIncomeTax);
            
        } else {
            System.out.println("Too many invalid attempts. Exiting program.");
        }
        
        scnr.close();
    }
}