package Lab_day4.CustomException;

public class Main {
    public static void main(String args[]) {
        MyClass myObject = new MyClass();
        try {
            myObject.checkTrue(true);
            myObject.checkTrue(false);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
