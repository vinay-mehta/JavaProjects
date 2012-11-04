/**
 * 
 */
package com.tw.main;

import com.tw.sampledata.SamplePatternData;

/**
 * @author vinaymehta
 * 
 */
public class ProcessGame {

	private boolean[][] gameState;

	/**
	 * @return the gameState
	 */
	public boolean[][] getGameState() {
		return gameState;
	}

	/**
	 * @param gameState
	 *            the gameState to set
	 */
	public void setGameState(boolean[][] gameState) {
		this.gameState = gameState;
	}

	/*
	 * Rules for the playing the Game
	 * 1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	 * 2. Any live cell with two or three live neighbours lives on to the next generation.
     * 3. Any live cell with more than three live neighbours dies, as if by overcrowding.
     * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 */
	public void processNextGeneration() {
		boolean[][] outputGrid = SamplePatternData.getInitialGrid();
		for (int i = 0; i < gameState.length; i++) {
			for (int j = 0; j < gameState[i].length; j++) {
				int nearLives = getLiveNeighbourCount(i, j);
				outputGrid[i][j] = gameState[i][j]; // Rule 3
				if (gameState[i][j]) {
					if (nearLives < 2 || nearLives > 3)// Rule 1 and 2
						outputGrid[i][j] = false;
				} else {
					if (nearLives == 3) {// Rule 4
						outputGrid[i][j] = true;
					}
				}
			}
		}
		gameState = outputGrid;
	}

	/*
	 * This will check for the Live Neighbour in the All the 8 Adjacent Cells
	 * Input : row and column index for which Live Neighbour count requires
	 * Return value : count [total count of live neighbour
	 */
	private int getLiveNeighbourCount(int rowIdx, int colIdx) {
		int totalLiveNeighCount = 0;
		// 1. x,y+1
		if (checkLiveNeighbour(rowIdx, colIdx + 1))
			totalLiveNeighCount += 1;

		// 2. x,y-1
		if (checkLiveNeighbour(rowIdx, colIdx - 1))
			totalLiveNeighCount += 1;

		// 3. x+1,y
		if (checkLiveNeighbour(rowIdx + 1, colIdx))
			totalLiveNeighCount += 1;

		// 4. x+1,y+1
		if (checkLiveNeighbour(rowIdx + 1, colIdx + 1))
			totalLiveNeighCount += 1;

		// 5. x+1,y-1
		if (checkLiveNeighbour(rowIdx + 1, colIdx - 1))
			totalLiveNeighCount += 1;

		// 6. x-1,y
		if (checkLiveNeighbour(rowIdx - 1, colIdx))
			totalLiveNeighCount += 1;

		// 7. x-1,y+1
		if (checkLiveNeighbour(rowIdx - 1, colIdx + 1))
			totalLiveNeighCount += 1;

		// 8. x-1,y-1
		if (checkLiveNeighbour(rowIdx - 1, colIdx - 1))
			totalLiveNeighCount += 1;

		return totalLiveNeighCount;
	}

	/*
	 * this will check the boundary condition for the index X and Y on the Grid
	 * Input : row_index, column_index return Value : true/false
	 */
	private boolean checkLiveNeighbour(int rowIdx, int colIdx) {
		boolean neighbourLive = false;

		if (rowIdx > 0 && rowIdx < Constants.MAX_ROWS && colIdx > 0
				&& colIdx < Constants.MAX_COLS) {
			neighbourLive = gameState[rowIdx][colIdx];
		}

		return neighbourLive;
	}

	/*
	 *  Prints our Grid with fills with true/false boolean values
	 */
	public void printGrid(String msg) {
		System.out.println(msg);
		for (int r = 0; r < gameState.length; r++) {
			for (int c = 0; c < gameState[r].length; c++) {
				if (!gameState[r][c]) {
					System.out.print(" - ");
				} else {
					System.out.print(" x ");
				}
			}
			System.out.println();
		}
		System.out.println();

	}

}
