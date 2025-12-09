package Lab_day4.CustomException;

public class MyClass {
    public void checkTrue(Boolean test) throws MyException {
        if (test) {
            System.out.println("Successful");
        } else {
            throw new MyException("Failed");
        }
    }
}
