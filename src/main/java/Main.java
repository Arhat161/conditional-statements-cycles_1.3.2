import java.util.Scanner;

class Main {

    // Method for checking if a year is a leap year
    public static boolean checkYear(int year) {
        boolean result = false;
        if (year % 400 == 0) {
            result = true;
        } else if (year % 100 == 0) {
            result = false;
        } else {
            if (year % 4 == 0) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int userYear, userDays; // year and number of days in a year
        int hints = 0;
        Scanner scan = new Scanner(System.in);

        // main loop
        while (true) {
            System.out.println("Please input year and number of days in year, in format: xxxx yyy");
            // user enters a year
            if (scan.hasNextInt()) {
                userYear = scan.nextInt();
            } else {
                System.out.println("Sorry, but this is clearly not a number. Restart the program and try again!");
                scan.close();
                break;
            }
            // the user enters the number of days in a year
            if (scan.hasNextInt()) {
                userDays = scan.nextInt();
            } else {
                System.out.println("Sorry, but this is clearly not a number. Restart the program and try again!");
                scan.close();
                break;
            }
            // Checking for compliance with the pair "year - number of days"
            if (checkYear(userYear) && userDays != 366) {
                System.out.println("Not properly! This year has 366 days!");
                System.out.println("Points scored: " + hints);
                break;
            } else if (!checkYear(userYear) && userDays != 365) {
                System.out.println("Not properly! This year has 365 days!");
                System.out.println("Points scored: " + hints);
                break;
            } else {
                ++hints;
            }

        }
    }
}