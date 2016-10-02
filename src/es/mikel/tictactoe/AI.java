package es.mikel.tictactoe;

/**
 * @author Mikel
 *
 */
public class AI {
	private Game currentGame;
	private boolean isFirst;
	private Vector2[] gamePositions;
	
	public AI(Game currentGame) {
		this.currentGame = currentGame;
		isFirst = false;
		gamePositions = currentGame.getMapManager().getPositions();
	}
	
	public void thinkMovement() {
		
		firstMovement();
		
		checkDiagonals();
		
		checkRowsColumns();
		
		//it can't win by now, it also can't do first movements
	}

	private void checkRowsColumns() {
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
				
				if ((aux.contains("XX") && aux.contains(" ")) || aux.contains("X X")) {
					if (i == 0) {
						currentGame.getMapManager().changePositionValue(new Vector2(j, aux.indexOf(" ")), "O");
					} else {
						currentGame.getMapManager().changePositionValue(new Vector2(aux.indexOf(" "), j), "O");
					}
					break;
				}
			}
		}
	}

	private void checkDiagonals() {
		String aux = "";
		Vector2 newPosition = new Vector2();
		
		// Left to Right
		aux = gamePositions[0].getValue() + gamePositions[4].getValue() + gamePositions[8].getValue();

		if((aux.contains("XX") && aux.contains(" ")) || aux.contains("X X")) {
			
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
			currentGame.getMapManager().changePositionValue(newPosition, "0");
		}
		
		// Right to Left
		aux = gamePositions[2].getValue() + gamePositions[4].getValue() + gamePositions[6].getValue();

		if((aux.contains("XX") && aux.contains(" ")) || aux.contains("X X")) {
			
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
			currentGame.getMapManager().changePositionValue(newPosition, "O");
		}
	}

	private void firstMovement() {
		if (isFirst || currentGame.getMapManager().canChangePositionValue(new Vector2(1, 1))) {
			currentGame.getMapManager().changePositionValue(new Vector2(1, 1), "O");
		} else {
			currentGame.getMapManager().changePositionValue(new Vector2(0, 0), "O"); //TODO make it random ¿?
		}
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	
	
}