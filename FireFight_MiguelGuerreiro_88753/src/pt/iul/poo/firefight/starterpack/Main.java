package pt.iul.poo.firefight.starterpack;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		// Cria uma instancia de GameEngine e depois inicia o jogo
		// Podera' vir a ficar diferente caso defina GameEngine como solitao
		
		GameEngine game = new GameEngine();
		game.start();
		
	}
}
