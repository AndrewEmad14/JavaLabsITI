package Lab_day4.Complex;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Complex<Integer> c1 = new Complex<>(3, 4);
        Complex<Integer> c2 = new Complex<>(1, 2);

        c1.addComplex(c2);
        System.out.println("Add: " + c1);

        c1.setReal(3);
        c1.setImaginary(4);
        c1.subtractComplex(c2);
        System.out.println("Subtract: " + c1);

        c1.setReal(3);
        c1.setImaginary(4);
        c1.multiplyComplex(c2);
        System.out.println("Multiply: " + c1);

        c1.setReal(3);
        c1.setImaginary(4);
        c1.divideComplex(c2);
        System.out.println("Divide: " + c1);

        Complex<Double> d1 = new Complex<>(3.5, 4.5);
        Complex<Double> d2 = new Complex<>(1.5, 2.5);

        d1.addComplex(d2);
        System.out.println("Add: " + d1);

        d1.setReal(3.5);
        d1.setImaginary(4.5);
        d1.subtractComplex(d2);
        System.out.println("Subtract: " + d1);

        d1.setReal(3.5);
        d1.setImaginary(4.5);
        d1.multiplyComplex(d2);
        System.out.println("Multiply: " + d1);

        d1.setReal(3.5);
        d1.setImaginary(4.5);
        d1.divideComplex(d2);
        System.out.println("Divide: " + d1);
    }
}
