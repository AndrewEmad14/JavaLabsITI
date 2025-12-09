import java.util.Scanner;
import java.util.function.Function;
import java.util.InputMismatchException;

class Converter {
	public static void main(String args[]) {

		Function<Double, Double> celsiusToFahrenheit = celsius -> (celsius * 9 / 5) + 32;
		System.out.println("Please Enter a centigrate temperture degree");
		Scanner scan = new Scanner(System.in);
		Boolean exit = false;
		while (!exit) {
			try {
				Double input = scan.nextDouble();

				exit = true;
				Double answer = celsiusToFahrenheit.apply(input);
				System.out.println("Fahernheit: " + answer);
			} catch (InputMismatchException e) {
				System.out.println("INVALID INPUT PLEASE TRY AGAIN");
				scan.next();
			}
		}

	}

}
