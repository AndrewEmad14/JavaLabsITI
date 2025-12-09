import java.util.Scanner;

class IPAddressChecker {

    public static void main(String[] args) {
        String regex = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while (true) {
            if (input.matches(regex)) {
                System.out.println("VALID IP ADDRESS");
            } else {
                System.out.println("INVALID IP ADDRESS");
            }
            input = scan.next();
        }

    }

};
