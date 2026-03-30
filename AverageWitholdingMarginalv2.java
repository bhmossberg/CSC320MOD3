import java.util.Scanner;

public class AverageWitholdingMarginalv2 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("=== Progressive Weekly Tax Calculator ===\n");

        // Step 1: Get weekly income with validation
        double weeklyIncome = getPositiveDouble(scnr, "Enter your weekly income: $");

        // Step 2: Allow user to configure the four tax brackets
        System.out.println("\nNow configure the tax brackets (weekly amounts):");

        double bracket1Cutoff = getPositiveDouble(scnr, "Bracket 1 upper limit (e.g. 500.00): $");
        double bracket2Cutoff = getPositiveDouble(scnr, "Bracket 2 upper limit (e.g. 1500.00): $");
        double bracket3Cutoff = getPositiveDouble(scnr, "Bracket 3 upper limit (e.g. 2500.00): $");
        // Bracket 4 has no upper limit

        double rate1 = getTaxRate(scnr, "Bracket 1 tax rate (e.g. 10): ");
        double rate2 = getTaxRate(scnr, "Bracket 2 tax rate (e.g. 15): ");
        double rate3 = getTaxRate(scnr, "Bracket 3 tax rate (e.g. 20): ");
        double rate4 = getTaxRate(scnr, "Bracket 4 tax rate (e.g. 30): ");

        // Calculate progressive tax
        double taxBracket1 = 0.0, taxBracket2 = 0.0, taxBracket3 = 0.0, taxBracket4 = 0.0;
        int marginalRate = 0;

        if (weeklyIncome < bracket1Cutoff) {
            taxBracket1 = weeklyIncome;
            marginalRate = (int) rate1;
        } 
        else if (weeklyIncome < bracket2Cutoff) {
            taxBracket1 = bracket1Cutoff;
            taxBracket2 = weeklyIncome - bracket1Cutoff;
            marginalRate = (int) rate2;
        } 
        else if (weeklyIncome < bracket3Cutoff) {
            taxBracket1 = bracket1Cutoff;
            taxBracket2 = bracket2Cutoff - bracket1Cutoff;
            taxBracket3 = weeklyIncome - bracket2Cutoff;
            marginalRate = (int) rate3;
        } 
        else {
            taxBracket1 = bracket1Cutoff;
            taxBracket2 = bracket2Cutoff - bracket1Cutoff;
            taxBracket3 = bracket3Cutoff - bracket2Cutoff;
            taxBracket4 = weeklyIncome - bracket3Cutoff;
            marginalRate = (int) rate4;
        }

        // Convert taxable amounts to actual tax
        double tax1 = taxBracket1 * (rate1 / 100.0);
        double tax2 = taxBracket2 * (rate2 / 100.0);
        double tax3 = taxBracket3 * (rate3 / 100.0);
        double tax4 = taxBracket4 * (rate4 / 100.0);

        double totalWeeklyTax = tax1 + tax2 + tax3 + tax4;
        double averageTaxRate = (weeklyIncome > 0) ? (totalWeeklyTax / weeklyIncome) * 100 : 0;

        double annualIncome = weeklyIncome * 52;
        double annualTax = totalWeeklyTax * 52;

        // Output results
        System.out.println("\n" + "=".repeat(50));
        System.out.printf("Weekly Income:          $%,.2f%n", weeklyIncome);
        System.out.printf("Annual Income:          $%,.2f%n", annualIncome);
        System.out.println("-".repeat(50));
        System.out.printf("Total Weekly Tax:       $%,.2f%n", totalWeeklyTax);
        System.out.printf("Total Annual Tax:       $%,.2f%n", annualTax);
        System.out.printf("Marginal Tax Rate:      %d%%%n", marginalRate);
        System.out.printf("Average Tax Rate:       %.2f%%%n", averageTaxRate);
        System.out.println("=".repeat(50));

        scnr.close();
    }


    /**
     * Reusable method to get a positive double value with validation
     */
    private static double getPositiveDouble(Scanner scnr, String prompt) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print(prompt);
            String input = scnr.nextLine().trim();

            try {
                double value = Double.parseDouble(input);
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Value must be 0 or greater. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            }

            attempts++;
        }

        System.out.println("Too many invalid attempts. Exiting program.");
        System.exit(1);
        return 0.0;
    }

    /**
     * Reusable method to get a tax rate (0-100)
     */
    private static double getTaxRate(Scanner scnr, String prompt) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print(prompt);
            String input = scnr.nextLine().trim();

            try {
                double rate = Double.parseDouble(input);
                if (rate >= 0 && rate <= 100) {
                    return rate;
                } else {
                    System.out.println("Tax rate must be between 0 and 100. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            }

            attempts++;
        }

        System.out.println("Too many invalid attempts. Exiting program.");
        System.exit(1);
        return 0.0;
    }
}