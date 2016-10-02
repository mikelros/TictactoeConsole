package es.mikel.tictactoe;

import java.util.Random;

/**
 * @author Mikel
 *
 */
public class Game {
	private MapManager mapManager;
	private Player player;
	private AI ai;
	
	public MapManager getMapManager() {
		return mapManager;
	}

	public Game() {
		mapManager = new MapManager();
		player = new Player(this);
		player.setIcon("X");
		ai = new AI(this);
		ai.setIcon("O");
		setFirst();
		loop();
	}

	private void loop() {
		while (isNotGameOver()) {
			clearConsole();
			printCurrentMapStatus();
			thinkMovements();
		}

	}

	private void thinkMovements() {
		//TODO fix game flux
		if (player.isFirst()) {
			player.thinkMovement();
			ai.thinkMovement();
		} else {
			ai.thinkMovement();
			printCurrentMapStatus();
			player.thinkMovement();
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
			System.err.println(ex.getMessage());
		}
	}
	
	private void setFirst() {
		Random rnd = new Random();
		int chosen = rnd.nextInt(2);
  
		if (chosen == 0) {
			player.setFirst(true);
		} else {
			ai.setFirst(true);
		}
	}

}
