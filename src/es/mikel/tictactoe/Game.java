package es.mikel.tictactoe;

/**
 * @author Mikel
 *
 */
public class Game {
	private MapManager mapManager;
	private Player player;
	private IA ia;
	
	public MapManager getMapManager() {
		return mapManager;
	}

	public Game() {
		mapManager = new MapManager();
		player = new Player(this);
		ia = new IA(this);
		loop();
	}

	private void loop() {
		while (isNotGameOver()) {
			clearConsole();
			printCurrentMapStatus();
		}

	}

	private void printCurrentMapStatus() {
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
		System.out.println("Write the position where you want to put your token (x, y -> ex: 1, 1):");
		player.thinkMovement();
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

	public static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception ex) {
		}
	}

}
