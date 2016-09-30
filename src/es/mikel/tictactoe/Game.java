package es.mikel.tictactoe;

import java.util.Scanner;

/**
 * @author Mikel
 *
 */
public class Game {
	private MapManager mapManager;

	public Game() {
		mapManager = new MapManager();
		loop();
	}

	private void loop() {
		while (isNotGameOver()) {
			printCurrentMapStatus();
		}

	}

	private void printCurrentMapStatus() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                 ╔═══╦═══╦═══╗                ║");
		System.out.println("║                 ║ " + mapManager.getPositions()[6].getValue() +  " ║ " + mapManager.getPositions()[7].getValue() + " ║ " + mapManager.getPositions()[8].getValue() + " ║                ║");
		System.out.println("║                 ╠═══╬═══╬═══╣                ║");
		System.out.println("║                 ║ " + mapManager.getPositions()[3].getValue() +  " ║ " + mapManager.getPositions()[4].getValue() + " ║ " + mapManager.getPositions()[5].getValue() + " ║                ║");
		System.out.println("║                 ╠═══╬═══╬═══╣                ║");
		System.out.println("║                 ║ " + mapManager.getPositions()[0].getValue() +  " ║ " + mapManager.getPositions()[1].getValue() + " ║ " + mapManager.getPositions()[2].getValue() + " ║                ║");
		System.out.println("║                 ╚═══╩═══╩═══╝                ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.println("");
		System.out.println("Write the position where you want to put your token (x, y):");
		
		String desiredPositionAnswer = scanner.nextLine();
		
		desiredPositionAnswer = desiredPositionAnswer.length() == 4 ? desiredPositionAnswer : "null";
		
		int desiredX = isNumeric(String.valueOf(desiredPositionAnswer.charAt(0))) ? Character.getNumericValue(desiredPositionAnswer.charAt(0)) : -1;
		int desiredY = isNumeric(String.valueOf(desiredPositionAnswer.charAt(3))) ? Character.getNumericValue(desiredPositionAnswer.charAt(0)) : -1;
		
		Vector2 desiredPosition = new Vector2(desiredX, desiredY, "X");
		
		if (desiredX != -1 && desiredY != -1 && mapManager.canChangePositionValue(desiredPosition)) {
			mapManager.changePositionValue(desiredPosition);
		} else {
			System.out.println("That's not a valid position.");
		}
	}

	private boolean isNotGameOver() {
		return true;
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
