package Lab_day4.LamdaString;

public class StringUtils {
    public static String betterString(String first, String second, LambdaBetterString action) {
        if (action.getBetterString(first, second)) {
            return first;
        } else {
            return second;
        }
    }
}
