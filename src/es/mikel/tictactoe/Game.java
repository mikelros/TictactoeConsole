package es.mikel.tictactoe;

import java.util.Scanner;

/**
 * @author Mikel
 *
 */
public class Game {
	public Game() {
		loop();
	}
	
	private void loop() {
		while (true) {
			printCurrentMapStatus();	
		}
		
	}

	private void printCurrentMapStatus() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("╔═══════════════════════════════════════════╗");
		System.out.println("║                 ╔══╦══╦══╗                ║");
		System.out.println("║                 ║  ║  ║  ║                ║");
		System.out.println("║                 ╠══╬══╬══╣                ║");
		System.out.println("║                 ║  ║  ║  ║                ║");
		System.out.println("║                 ╠══╬══╬══╣                ║");
		System.out.println("║                 ║  ║  ║  ║                ║");
		System.out.println("║                 ╚══╩══╩══╝                ║");
		System.out.println("╚═══════════════════════════════════════════╝");
		System.out.println("");
		System.out.println("Write the position where you want to put your token (x, y):");
		
		String desiredPosition = scanner.nextLine();
		
	}
}
