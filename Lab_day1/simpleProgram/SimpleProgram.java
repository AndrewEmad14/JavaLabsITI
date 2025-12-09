import java.util.Scanner;

public class SimpleProgram {

	public static void main(String[] args) {
		System.out.println("Hello User");
		// checks one input
		if (args.length > 0) {
			System.out.println(args[0]);
		} else {
			System.out.println("no Input");
		}

		/*
		 * if(args.length>=2){
		 * System.out.println("THERE ARE ARGUMENTS");
		 * int number=0;
		 * try{
		 * number=Integer.parseInt(args[0]);
		 * }catch(NumberFormatException e){
		 * System.out.println("YOU DIDNT INPUT A NUMBER,TRY AGAIN");
		 * }
		 * System.out.println("Number= "+number);
		 * for(int i=0;i<number;i++){
		 * System.out.println(args[1]);
		 * }
		 * 
		 * 
		 * }else{
		 * System.out.println(args.length);
		 * }
		 */

	}
}
