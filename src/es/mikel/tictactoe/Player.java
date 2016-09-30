package es.mikel.tictactoe;

import java.util.Scanner;

/**
 * @author Mikel
 *
 */
public class Player {
	private Game currentGame;
	
	public Player(Game currentGame) {
		this.currentGame = currentGame;
	}
	
	public void thinkMovement() {
		Scanner scanner = new Scanner(System.in);
		String desiredPositionAnswer = scanner.nextLine();

		desiredPositionAnswer = desiredPositionAnswer.length() == 4 ? desiredPositionAnswer : "null";

		int desiredX = Game.isNumeric(String.valueOf(desiredPositionAnswer.charAt(0)))
				? Character.getNumericValue(desiredPositionAnswer.charAt(0)) : -1;
		int desiredY = Game.isNumeric(String.valueOf(desiredPositionAnswer.charAt(3)))
				? Character.getNumericValue(desiredPositionAnswer.charAt(0)) : -1;

		Vector2 desiredPosition = new Vector2(desiredX, desiredY, "X");
		makeMovement(scanner, desiredPosition);
	}
	
	private void makeMovement(Scanner scanner, Vector2 desiredPosition) {
		if (desiredPosition.getX() != -1 && desiredPosition.getY() != -1 && currentGame.getMapManager().canChangePositionValue(desiredPosition)) {
			currentGame.getMapManager().changePositionValue(desiredPosition);
		} else {
			System.out.println("That's not a valid position.");
			scanner.nextLine();
		}
	}
	
	
}
