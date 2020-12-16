import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean again = true;

        while (again) {

	        System.out.println("Enter date (DD-MM-YYYY), or EXIT: ");
	        String date = scan.nextLine().trim();

	        if (date.toLowerCase().equals("exit")) {
	        	again = false;
	        	break;
	        } else if (!isProperFormat(date)) {
	        	System.out.println("NOT DATE FORMAT. PLEASE TRY AGAIN");
	        	continue;
	        };

	        int day = Integer.parseInt(date.split("-")[0]);
	        int month = Integer.parseInt(date.split("-")[1]);
	        int year = Integer.parseInt(date.split("-")[2]);

	        if (day > 31 || month > 12) {
	        	System.out.println("INVALID DATE. PLEASE TRY AGAIN");
	        	continue;
	        };

	        String output = day + "-" + month + "-" + year + " is a ";
	        output += dayOfWeek(day, month, year) + ".";
	        System.out.println(output);
	        System.out.println("Go again? Yes or No: ");
	        if (scan.nextLine().equalsIgnoreCase("No")) again = false;

        }
        scan.close();
    }

    public static String dayOfWeek(int day, int month, int year) {
        int monthCode = calcMonthCode(month, year);
        int yearCode = calcYearCode(year);
        return calcDayOfWeek(day, monthCode, yearCode);
    }

    protected static boolean isProperFormat(String date) {
    	return Pattern.matches("\\d{2}-\\d{2}-\\d{4}", date);
    }

    protected static int calcMonthCode(int month, int year) {
    	int[] monthCodes;
    	if (isLeapYear(year)) {
    		monthCodes = new int[] {0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    	} else {
    		monthCodes = new int[] {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    	};
    	return monthCodes[month-1];
    }

    protected static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    protected static int calcYearCode(int year) {
    	int lastTwo = year % 100;
    	return lastTwo + (int) lastTwo/4 + calcCenturyCode(year);
    }

    protected static int calcCenturyCode(int year) {
    	int[] centuryCodes = {6, 4, 2, 0};
        return centuryCodes[(int)(year/100)%4];
    }

    protected static String calcDayOfWeek(int dayCode, int monthCode,
    									  int yearCode) {
    	String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday",
    	                     "Wednesday", "Thursday", "Friday"};
        return daysOfWeek[(dayCode + monthCode + yearCode) % 7];
    }
}
