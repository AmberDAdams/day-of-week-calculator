import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter day: ");
        int day = Integer.parseInt(scan.nextLine());
        System.out.println("Enter month: ");
        int month = Integer.parseInt(scan.nextLine());
        System.out.println("Enter year: ");
        int year = Integer.parseInt(scan.nextLine());
        scan.close();
        String output = day + "-" + month + "-" + year + " is a ";
        output += dayOfWeek(day, month, year) + ".";
        System.out.println(output);
        
    }
    
    public static String dayOfWeek(int day, int month, int year) {
        int dayCode = calcDayCode(day);
        int monthCode = calcMonthCode(month, year);
        int yearCode = calcYearCode(year);
        return calcDayOfWeek(dayCode, monthCode, yearCode);
    }
    
    protected static int calcDayCode(int day){
        return day;
    }
    
    protected static int calcMonthCode(int month, int year) {
        switch (month) {
            case 3:
                return 4;
            case 4:
                return 0;
            case 5:
                return 2;
            case 6:
                return 5;
            case 7:
                return 0;
            case 8:
                return 3;
            case 9:
                return 6;
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 6;
            case 1:
                if (isLeapYear(year)) return 0;
                return 1;
            case 2:
                if (isLeapYear(year)) return 3;
                return 4;
        }
        return 0; //should never be returned
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
        switch ((year/100) % 4) {
            case 3:
                return 0;
            case 2: 
                return 2;
            case 1:
                return 4;
            default:
                return 6;
        }
    }
    
    protected static String calcDayOfWeek(int dayCode, int monthCode, int yearCode) {
        switch ((dayCode + monthCode + yearCode) % 7) {
            case 0:
                return "Saturday";
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
        }
        return "Someday"; //this should never be returned
    }	
}
