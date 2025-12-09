package Lab_day4.CustomException;

class MyException extends Exception {
    MyException() {
        super("YO I AM A NEW EXCEPTION");
    }

    MyException(String message) {
        super(message);
    }
}