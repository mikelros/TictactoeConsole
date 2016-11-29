package es.mikel.tictactoe;

import java.util.Arrays;

/**
 * @author Mikel
 *
 */
public class MapManager {
	private Vector2[] positions;

	public MapManager() {
		positions = new Vector2[] { new Vector2(0, 0), new Vector2(1, 0), new Vector2(2, 0),
				new Vector2(0, 1), new Vector2(1, 1), new Vector2(2, 1), new Vector2(0, 2),
				new Vector2(1, 2), new Vector2(2, 2) };
	}

	public Vector2[] getPositions() {
		return positions;
	}

	public boolean canChangePositionValue(Vector2 position) {
		return (Arrays.asList(positions).contains(position)
				&& Arrays.asList(positions).get(Arrays.asList(positions).indexOf(position)).getValue() == " ") ? true
						: false;
	}

	public void changePositionValue(Vector2 position) {
		Arrays.asList(positions).get(Arrays.asList(positions).indexOf(position)).setX(position.getX());
		Arrays.asList(positions).get(Arrays.asList(positions).indexOf(position)).setY(position.getY());
		Arrays.asList(positions).get(Arrays.asList(positions).indexOf(position)).setValue(position.getValue());
		;
	}
}
