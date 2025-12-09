import java.util.Scanner;
import java.util.function.Function;
import java.util.InputMismatchException;

//@FunctionalInterface
//interface TriFunction<T, U, V, R> {
//    R apply(T t, U u, V v);
//}
class RootQuadraticEquation {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		Boolean exit = false;
		Double number1 = 0.0;
		Double number2 = 0.0;
		Double number3 = 0.0;
		while (!exit) {
			try {
				number1 = scan.nextDouble();
				if (number1 == 0) {
					throw new IllegalArgumentException("'a' cannot be zero in a quadratic equation!");
				}
				exit = true;

			} catch (InputMismatchException e) {
				System.out.println("INVALID INPUT PLEASE TRY AGAIN");
				scan.next();

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				// scan.next();
			}
		}
		exit = false;

		while (!exit) {
			try {
				number2 = scan.nextDouble();
				exit = true;

			} catch (InputMismatchException e) {
				System.out.println("INVALID INPUT PLEASE TRY AGAIN");
				scan.next();
			}
		}
		exit = false;
		while (!exit) {
			try {
				number3 = scan.nextDouble();
				exit = true;

			} catch (InputMismatchException e) {
				System.out.println("INVALID INPUT PLEASE TRY AGAIN");
				scan.next();
			}
		}
		Double tempNumber[] = { number1, number2, number3 };

		Function<Double[], String> solveQuadratic = number -> {
			Double a = number[0];
			Double b = number[1];
			Double c = number[2];
			Double determinant = b * b - 4 * a * c;
			Double firstroot = 0.0;
			Double secondroot = 0.0;
			if (determinant > 0) {

				firstroot = (-b + Math.sqrt(determinant)) / (2 * a);
				secondroot = (-b - Math.sqrt(determinant)) / (2 * a);

				return "First Root = " + firstroot + " and Second Root = " + secondroot;
			} else {
				// roots are complex number and distinct
				Double real = -b / (2 * a);

				Double imaginary = Math.sqrt(-determinant) / (2 * a);

				return "First Root = " + real + "+" + imaginary + "i\n" + "Second Root = " + real + "-" + imaginary
						+ "i";
			}

		};
		System.out.println(solveQuadratic.apply(tempNumber));

	}
}
