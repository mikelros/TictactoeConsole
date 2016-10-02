package es.mikel.tictactoe;

import java.util.Scanner;

/**
 * @author Mikel
 *
 */
public class Player {
	private Game currentGame;
	private boolean isFirst;
	private String icon;
	
	public Player(Game currentGame) {
		this.currentGame = currentGame;
		isFirst = false;
	}
	
	public void thinkMovement() {
		Scanner scanner = new Scanner(System.in);
		String desiredPositionAnswer = scanner.nextLine();

		desiredPositionAnswer = desiredPositionAnswer.length() == 4 ? desiredPositionAnswer : "null";

		int desiredX = Game.isNumeric(String.valueOf(desiredPositionAnswer.charAt(0)))
				? Character.getNumericValue(desiredPositionAnswer.charAt(0)) : -1;
		int desiredY = Game.isNumeric(String.valueOf(desiredPositionAnswer.charAt(3)))
				? Character.getNumericValue(desiredPositionAnswer.charAt(3)) : -1;

		Vector2 desiredPosition = new Vector2(desiredX, desiredY, icon);
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

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
