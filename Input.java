import java.util.Scanner;

public class Input {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static String getLine(String prompt) {
		System.out.print(prompt);
		return Input.sc.nextLine();
	}
	
	public static int getInt(String prompt) {
		int userInput = 0;
		System.out.print(prompt);
		while(true) {
			if(Input.sc.hasNextInt())
				break;
			System.out.printf("Invalid Input! Enter a number: ");
			Input.sc.next();
		}
		userInput = Input.sc.nextInt();
		Input.sc.nextInt();
		return userInput;
	}
	
	public static int getIntRange(String prompt, int low, int high) {
		int userInput;
		System.out.print(prompt);
		while(true) {
			if(Input.sc.hasNextInt()) {
				userInput = Input.sc.nextInt();
				if(userInput >= low && userInput <= high) {
					break;
				}
			} else {
				Input.sc.next();
			}
			System.out.printf("Invalid Input! Please enter a number between (%d - %d): ", low, high);
		}
		Input.sc.nextLine();
		return userInput;
	}
}
