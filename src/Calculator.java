import java.util.Scanner;

import javax.swing.JOptionPane;

public class Calculator {

	public static void main(String args[]) {
		System.out.println("===LOG TIME CALCULATOR===\nBy Vince Ou\n"
				+ "Enter your previous log time...\nIn hours:minutes format:");
		Scanner keyboard = new Scanner(System.in);
		String prevTime = keyboard.nextLine();
		int timeTotal = 0;
		if (!(prevTime.equals("0") || prevTime.equals(""))) {
			timeTotal += 60 * Integer.parseInt(prevTime.substring(0,
					prevTime.indexOf(":")));
			timeTotal += Integer.parseInt(prevTime.substring(
					prevTime.indexOf(":") + 1, prevTime.length()));
		}
		System.out.println("Now enter your log times in minutes.\n"
				+ "After the last entry, enter a space and press enter");
		String input = keyboard.nextLine();
		do {
			try {
				timeTotal += Integer.parseInt(input);
			} catch (Exception e) {
			}
			input = keyboard.nextLine();
		} while (!(input.equals(" ") || input.equals("")));
		System.out.println("Your log time is: " + (int) (timeTotal / 60)
				+ " hour(s) and " + timeTotal % 60 + " minute(s).");
		keyboard.close();
	}
}
