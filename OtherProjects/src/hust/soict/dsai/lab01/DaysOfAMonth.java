package hust.soict.dsai.lab01;
import java.util.Scanner;
public class DaysOfAMonth {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int month = 0;
        int year = -1;
        while(true){
            System.out.print("Enter month: ");
            String input = scanner.nextLine().trim();
            month = convertMonth(input);
            if (month != 0) break;
            System.out.println("Invalid month");
        }

        while(true){
            System.out.print("Enter year: ");
            String input = scanner.nextLine();
            boolean isNumber = true;
            for(int i = 0; i < input.length(); i++){
                if(!Character.isDigit(input.charAt(i))){
                    isNumber = false;
                    break;
                }
            }
            if(isNumber && input.length() > 0){
                year = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid year");
        }

        boolean isLeap = false;
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) isLeap = true;
        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31; 
                break;
            case 4: case 6: case 9: case 11:
                days = 30; 
                break;
            case 2:
                days = isLeap ? 29 : 28;
                break;
        }

        System.out.println("Number of days: " + days);
        scanner.close();
    }

    public static int convertMonth(String m){
        m = m.toLowerCase();
        switch (m){
            case "january": case "jan": case "jan.": case "1":
                return 1;
            case "february": case "feb": case "feb.": case "2":
                return 2;
            case "march": case "mar": case "mar.": case "3":
                return 3;
            case "april": case "apr": case "apr.": case "4":
                return 4;
            case "may": case "5":
                return 5;
            case "june": case "jun": case "6":
                return 6;
            case "july": case "jul": case "7":
                return 7;
            case "august": case "aug": case "aug.": case "8":
                return 8;
            case "september": case "sep": case "sept.": case "9":
                return 9;
            case "october": case "oct": case "oct.": case "10":
                return 10;
            case "november": case "nov": case "nov.": case "11":
                return 11;
            case "december": case "dec": case "dec.": case "12":
                return 12;
            default:
                return 0;
        }
    }
}