package es.mikel.tictactoe;

import java.util.Random;

/**
 * @author Mikel
 *
 */
public class AI {
	private Game currentGame;
	private boolean isFirst;
	public boolean hasDoneFirstMovement;
	private Vector2[] gamePositions;
	private String difficulty;
	private String icon;
	
	public AI(Game currentGame) {
		this.currentGame = currentGame;
		isFirst = false;
		gamePositions = currentGame.getMapManager().getPositions();
		hasDoneFirstMovement = false;
	}
	
	public void thinkMovement() {
		
		if (hasDoneFirstMovement && ! checkHasWinningSituation() && ! checkHasLosingSituation()) {
			randomMovement();
			System.out.println("Done rnd move");
		}
		
		firstMovement();
		//Apparently fixed
		
	}

	private boolean checkHasLosingSituation() {
		return checkDiagonals(icon == "X" ? "O" : "X") || checkRowsColumns(icon == "X" ? "O" : "X");
	}

	private boolean checkHasWinningSituation() {
		return checkDiagonals(icon) || checkRowsColumns(icon);
	}

	private void randomMovement() {
		Random rnd = new Random();
		Vector2 position = new Vector2();
		do {
			position = new Vector2(rnd.nextInt(3), rnd.nextInt(3), icon);
		} while (! currentGame.getMapManager().canChangePositionValue(position));
		currentGame.getMapManager().changePositionValue(position);
	}

	private boolean checkRowsColumns(String value) {
		String aux = "";
		int count = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				//Zero is checking columns and one is checking rows
				if (i == 0) {
					aux = gamePositions[j].getValue() + gamePositions[j + 3].getValue() + gamePositions[j + 6].getValue();
				} else {					
					aux = gamePositions[j + count].getValue() + gamePositions[j + count + 1].getValue() + gamePositions[j + count + 2].getValue();
					count += 2;
				}
				
				if ((aux.contains(value + value) && aux.contains(" ")) || aux.contains(value + " " + value)) {
					if (i == 0) {
						currentGame.getMapManager().changePositionValue(new Vector2(j, aux.indexOf(" "), icon));
					} else {
						currentGame.getMapManager().changePositionValue(new Vector2(aux.indexOf(" "), j, icon));
					}
					return true;
				}
			}
		}
		
		return false;
	}

	private boolean checkDiagonals(String value) {
		String aux = "";
		Vector2 newPosition = new Vector2();
		newPosition.setValue(icon);
		
		// Left to Right
		aux = gamePositions[0].getValue() + gamePositions[4].getValue() + gamePositions[8].getValue();

		if((aux.contains(value + value) && aux.contains(" ")) || aux.contains(value + " " + value)) {
			
			switch (aux.indexOf(" ")) {
			case 0:
				newPosition.setX(0);
				newPosition.setY(0);
				break;
			case 1:
				newPosition.setX(1);
				newPosition.setY(1);
				break;
			case 2:
				newPosition.setX(2);
				newPosition.setY(2);
				break;
			default:
				newPosition.setX(-1);
				newPosition.setY(-1);
				break;
			}
			currentGame.getMapManager().changePositionValue(newPosition);
			return true;
		}
		
		// Right to Left
		aux = gamePositions[2].getValue() + gamePositions[4].getValue() + gamePositions[6].getValue();

		if((aux.contains(value + value) && aux.contains(" ")) || aux.contains(value + " " + value)) {
			
			switch (aux.indexOf(" ")) {
			case 0:
				newPosition.setX(2);
				newPosition.setY(0);
				break;
			case 1:
				newPosition.setX(1);
				newPosition.setY(1);
				break;
			case 2:
				newPosition.setX(0);
				newPosition.setY(2);
				break;
			default:
				newPosition.setX(-1);
				newPosition.setY(-1);
				break;
			}
			currentGame.getMapManager().changePositionValue(newPosition);
			return true;
		}
		
		return false;
	}

	private void firstMovement() {
		if(! hasDoneFirstMovement) {
			if (isFirst && currentGame.getMapManager().canChangePositionValue(new Vector2(1, 1, icon))) {
				currentGame.getMapManager().changePositionValue(new Vector2(1, 1, icon));
			} else {
				randomMovement();
			}
			
			hasDoneFirstMovement = true;
		}
		
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}