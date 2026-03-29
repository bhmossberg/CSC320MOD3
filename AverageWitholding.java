import java.util.Scanner;

public class AverageWitholding {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        double income = 0.0;
        boolean validInput = false;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        
        // Input with validation
        while (attempts < MAX_ATTEMPTS && !validInput) {
            System.out.println("Enter your annual salary:");
            String input = scnr.next();
            
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
            
            double taxRate;
            String bracketDescription;
            
            // Determine flat tax rate based on income bracket
            if (income < 500) {
                taxRate = 0.10;
                bracketDescription = "10%";
            } 
            else if (income < 1500) {
                taxRate = 0.15;
                bracketDescription = "15%";
            } 
            else if (income < 2500) {
                taxRate = 0.20;
                bracketDescription = "20%";
            } 
            else {
                taxRate = 0.30;
                bracketDescription = "30%";
            }
            
            double annualTax = income * taxRate;
            double weeklyTax = annualTax / 52.0;
            double averageTaxRate = taxRate;   // Since it's flat, average = marginal
            
            // Output
            System.out.printf("Tax rate applied: %s%n", bracketDescription);
            System.out.printf("Total annual tax burden: $%.2f%n", annualTax);
            System.out.printf("Average weekly tax withholding: $%.2f%n", weeklyTax);
            
        } else {
            System.out.println("Too many invalid attempts. Exiting program.");
        }
        
        scnr.close();
    }
}