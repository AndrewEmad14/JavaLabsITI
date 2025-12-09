import java.util.StringTokenizer;

class StringTask {
	public static int countDelimiter(String example, String delimiter) {
		int counter = 0;
		int currentIndex = example.indexOf(delimiter);

		while (currentIndex != -1) {
			counter++;
			currentIndex = example.indexOf(delimiter, currentIndex + 1);
		}
		return counter;
	}

	public static void main(String args[]) {

		String exampleStr = "ITI develops people and ITI house of developers and ITI for people I";
		String afterDelmiterGaurd = "_";
		String delimiter = "ITI";
		if (exampleStr.isEmpty()) {
			System.out.println("EMPTY STRING");
			return;
		}

		String[] answer1 = exampleStr.split(delimiter, -1);
		System.out.println("ITI occured " + (answer1.length - 1) + " Times!");

		String[] answer2 = exampleStr.splitWithDelimiters(delimiter, -1);

		System.out.println("ITI occured " + (answer2.length / 2) + " Times!");
		int counter = countDelimiter(exampleStr, delimiter);
		System.out.println("ITI occured " + counter + " Times!");

		if (exampleStr.contains("ITI")) {
			exampleStr += afterDelmiterGaurd;
			StringTokenizer tokenizer = new StringTokenizer(exampleStr, delimiter);
			System.out.println("ITI occured " + tokenizer.countTokens() + " Times!");

		} else {
			System.out.println("ITI occured " + 0 + " Times!");
		}

	}

};
