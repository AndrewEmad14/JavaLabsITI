package Lab_day4.AlphaChecker;

import java.util.Scanner;

public class Main {
    public static boolean isAlpha(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isLetter(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String:");
        String testString = scan.next();
        if (isAlpha(testString)) {
            System.out.println(" pure Alpha");
        } else {
            System.out.println("not pure Alpha");
        }
        scan.close();
    }
}
