import java.util.Scanner;

public class Seasons {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        String inputMonth = scnr.next();
        int inputDay = 0;
        
        // Try to read the day as integer
        try {
            inputDay = scnr.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid");
            scnr.close();
            return;
        }

        String month = inputMonth.toLowerCase();

        // Get base days for the month using switch expression
        int monthJulian = switch (month) {
            case "january"   -> 0;
            case "february"  -> 31;
            case "march"     -> 59;
            case "april"     -> 90;
            case "may"       -> 120;
            case "june"      -> 151;
            case "july"      -> 181;
            case "august"    -> 212;
            case "september" -> 243;
            case "october"   -> 273;
            case "november"  -> 304;
            case "december"  -> 334;
            default          -> -1;   // Invalid month
        };

        // If month is invalid, output Invalid
        if (monthJulian == -1) {
            System.out.println("Invalid");
            scnr.close();
            return;
        }

        // Calculate julian date
        int julianDate = monthJulian + inputDay;

        // Validate the day is reasonable for the month
        boolean validDay = true;
        
        switch (month) {
            case "february":
                if (inputDay < 1 || inputDay > 29) validDay = false;
                break;
            case "april":
            case "june":
            case "september":
            case "november":
                if (inputDay < 1 || inputDay > 30) validDay = false;
                break;
            default:  // 31-day months
                if (inputDay < 1 || inputDay > 31) validDay = false;
                break;
        }

        if (!validDay) {
            System.out.println("Invalid");
            scnr.close();
            return;
        }

        // Determine season using original logic
        if ((julianDate >= 79) && (julianDate <= 171)) {
            System.out.println("Spring");
        }
        else if ((julianDate >= 172) && (julianDate <= 264)) {
            System.out.println("Summer");
        }
        else if ((julianDate >= 265) && (julianDate <= 354)) {
            System.out.println("Autumn");
        }
        else if (((julianDate >= 355) && (julianDate <= 365)) || 
                 ((julianDate >= 1) && (julianDate <= 78))) {
            System.out.println("Winter");
        }
        else {
            System.out.println("Invalid");
        }

        scnr.close();
    }
}