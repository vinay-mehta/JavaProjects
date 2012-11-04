/**
 * 
 */
package com.tw.main;

/**
 * @author vinaymehta
 * 
 */
public class PlayGameOfLife {

	private ProcessGame pGame;

	public PlayGameOfLife(boolean[][] grid) {
		System.out.println("Game of Life Version : " + Constants.GAME_VERSION);
		pGame = new ProcessGame();
		pGame.setGameState(grid);
	}

	public void tick() {
		pGame.processNextGeneration();
	}

	public void play() {
		pGame.printGrid("GOL Grid Selected");
		tick();
		pGame.printGrid("GOL Grid Next Generation");
	}
}
