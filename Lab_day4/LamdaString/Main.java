package Lab_day4.LamdaString;

public class Main {
    public static void main(String[] args) {
        String string1 = "hello";

        String string2 = "my name is andrew";

        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());

        String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
        System.out.println(longer);
        System.out.println(first);

    }
}
