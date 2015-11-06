import javax.swing.JOptionPane;

public class Calculator {

	public static void main(String args[]) {
		String prevTime = JOptionPane
				.showInputDialog(
						null,
						"Welcome to Log Time Calculator.\n\nEnter your previously accumulated time,\nin hours:minutes format",
						"Welcome!", JOptionPane.QUESTION_MESSAGE).trim();
		while (!prevTime.matches("[0-9]{1,}:[0-9]{2}")) {
			prevTime = JOptionPane
					.showInputDialog(
							null,
							"Please enter a valid time,\nenter \"0:00\" if you do not have any time currently",
							"Input Error", JOptionPane.WARNING_MESSAGE);
		}

		String[] hoursMins = prevTime.split(":");
		int prevMins = 0;
		prevMins += 60 * Integer.parseInt(hoursMins[0]);
		prevMins += Integer.parseInt(hoursMins[1]);

		int newMins = 0;
		boolean moreInput;
		do {
			String input = JOptionPane
					.showInputDialog(
							null,
							"Now enter your flight time entry ,\nin hours:mins or just minutes",
							"Enter Times", JOptionPane.QUESTION_MESSAGE).trim();
			while (!(input.matches("[0-9]{1,}:[0-9]{2}") || input
					.matches("[0-9]{0,}"))) {
				input = JOptionPane
						.showInputDialog(
								null,
								"Try again, entering\nhours:mins or just minutes without punctuation",
								"Entry Error", JOptionPane.WARNING_MESSAGE)
						.trim();
			}

			if (input.matches("[0-9]{1,}:[0-9]{2}")) {
				String[] newTime = input.split(":");
				newMins += 60 * Integer.parseInt(newTime[0]);
				newMins += Integer.parseInt(newTime[1]);
			} else if (input.matches("[0-9]{0,}")) {
				newMins += Integer.parseInt(input);
			}

			if (JOptionPane.showConfirmDialog(null,
					"Do you have any more flights to enter?", "More Times?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				moreInput = true;
			else
				moreInput = false;
		} while (moreInput);

		String totalNewTime = toHoursMinutes(newMins);
		String totalTime = toHoursMinutes(newMins + prevMins);

		JOptionPane.showConfirmDialog(null, "Your total time is "
				+ totalTime + "\n Your time increased by " + totalNewTime
				+ " this session.", "Results", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
	}

	private static String toHoursMinutes(int minutes) {
		return String.format("%d:%02d", minutes / 60, minutes % 60);
	}
}
