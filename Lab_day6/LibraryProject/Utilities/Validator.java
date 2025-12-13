package Lab_day6.LibraryProject.Utilities;

public class Validator {
    public static Boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static Boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        String nameRegex = "^[a-zA-Z\\s]+$";
        return name.matches(nameRegex);
    }

    public static Boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Boolean isPositiveNumber(int number) {
        return number >= 0;
    }

    public static Boolean isVaildYear(String year) {
        String yearRegex = "\\b(0?[1-9]|[12]\\d|3[01])/(0?[1-9]|1[0-2])/(19|20)\\d{2}\\b";
        ;
        return year.matches(yearRegex);
    }

}
