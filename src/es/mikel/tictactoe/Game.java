package es.mikel.tictactoe;

import java.util.Random;
import java.util.Scanner;

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
		printMenu(); // TODO add code to each option, maybe splash screen before menu
		setFirst();
		loop();
		System.out.println("SESSION FINISHED");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
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
			if (isNotGameOver()) {
				ai.thinkMovement();	
			}
		} else {
			ai.thinkMovement();
			clearConsole();
			printCurrentMapStatus();
			if (isNotGameOver()) {
				player.thinkMovement();	
			}
		}
	}
	
	private void printCurrentMapStatus() {
		//TODO polish and fixing
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║        Playing against medium AI -> " + ai.getIcon() + "        ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                 ╔═══╦═══╦═══╗                ║");
		System.out.println("║                 ║ " + mapManager.getPositions()[6].getValue() +  " ║ " + mapManager.getPositions()[7].getValue() + " ║ " + mapManager.getPositions()[8].getValue() + " ║                ║");
		System.out.println("║                 ╠═══╬═══╬═══╣                ║");
		System.out.println("║                 ║ " + mapManager.getPositions()[3].getValue() +  " ║ " + mapManager.getPositions()[4].getValue() + " ║ " + mapManager.getPositions()[5].getValue() + " ║                ║");
		System.out.println("║                 ╠═══╬═══╬═══╣                ║");
		System.out.println("║                 ║ " + mapManager.getPositions()[0].getValue() +  " ║ " + mapManager.getPositions()[1].getValue() + " ║ " + mapManager.getPositions()[2].getValue() + " ║                ║");
		System.out.println("║                 ╚═══╩═══╩═══╝                ║");
		System.out.println("╠═══╦══════════════════════════════════════════╣");
		System.out.println("║ " + player.getIcon() +" ║ Where you want to put your token? (x, y) ║");
		System.out.println("╚═══╩══════════════════════════════════════════╝");//////////////////////
		System.out.println("");
		
	}

	private boolean isNotGameOver() {
		boolean isGameOver = false;
		String aux = "";
		int count = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				//Zero is checking columns and one is checking rows
				if (i == 0) {
					aux = mapManager.getPositions()[j].getValue() + mapManager.getPositions()[j + 3].getValue() + mapManager.getPositions()[j + 6].getValue();
				} else {					
					aux = mapManager.getPositions()[j + count].getValue() + mapManager.getPositions()[j + count + 1].getValue() + mapManager.getPositions()[j + count + 2].getValue();
					count += 2;
				}
				
				if (aux.contains("XXX") || aux.contains("OOO"))  {
					isGameOver = true;
				}
			}
		}
		
		// Left to Right
		aux = mapManager.getPositions()[0].getValue() + mapManager.getPositions()[4].getValue() + mapManager.getPositions()[8].getValue();
		
		if (aux.contains("XXX") || aux.contains("OOO"))  {
			isGameOver = true;
		}
		
		// Right to Left
		aux = mapManager.getPositions()[2].getValue() + mapManager.getPositions()[4].getValue() + mapManager.getPositions()[6].getValue();

		if (aux.contains("XXX") || aux.contains("OOO"))  {
			isGameOver = true;
		}
		
		aux = "";
		for (int i = 0; i < mapManager.getPositions().length; i++) {
			aux += mapManager.getPositions()[i].getValue();
		}
		
		if (! aux.contains(" ")) {
			isGameOver = true;
		}
		
		return !isGameOver;
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
	
	private void printMenu() {
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                  GAME MENU                   ║");
		System.out.println("╚══════════════════════════════════════════════╝");
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println("║                                              ║");
		System.out.println("║               1.- Start game                 ║");
		System.out.println("║               2.- Leaderboard                ║");
		System.out.println("║               3.- Config                     ║");
		System.out.println("║               4.- About                      ║");
		System.out.println("║               5.- Exit                       ║");
		System.out.println("║                                              ║");
		System.out.println("╠══════════════════════════════════════════════╣");
		System.out.println("║          Please select one option:           ║");
		System.out.println("╚══════════════════════════════════════════════╝");
	}

}
