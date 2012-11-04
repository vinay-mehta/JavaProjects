/**
 * 
 */
package com.tw.sampledata;

import com.tw.main.Constants;

/**
 * @author vinaymehta
 * 
 */
public class SamplePatternData {

	/** Creates a grid with Fixed length and sets all values false */
	public static boolean[][] getInitialGrid() {
		boolean[][] grid = new boolean[Constants.MAX_ROWS][Constants.MAX_COLS];

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				grid[r][c] = false;
			}

		}

		return grid;

	}

	/*
	 * Return the BLOCK Pattern 
	 */
	public static boolean[][] getBlockPattern() {
		boolean[][] block_grid = getInitialGrid();

		block_grid[1][1] = true;
		block_grid[1][2] = true;
		block_grid[2][1] = true;
		block_grid[2][2] = true;

		return block_grid;
	}
	
	/*
	 * Return the TOAD Pattern
	 */
	public static boolean[][] getToadPattern() {
		boolean[][] toad_grid = getInitialGrid();

		toad_grid[1][1] = true;
		toad_grid[1][2] = true;
		toad_grid[1][3] = true;
		toad_grid[2][2] = true;
		toad_grid[2][3] = true;
		toad_grid[2][4] = true;

		return toad_grid;
	}
	
	/*
	 * Return the Blikner Pattern
	 *  - X -
     *	- X -
     *	- X -
	 */
	public static boolean[][] getBlinkerPattern() {
		boolean[][] blinker_grid = getInitialGrid();

		blinker_grid[1][1] = false;
		blinker_grid[1][2] = true;
		blinker_grid[1][3] = false;
		blinker_grid[2][1] = false;
		blinker_grid[2][2] = true;
		blinker_grid[2][3] = false;
		blinker_grid[3][1] = false;
		blinker_grid[3][2] = true;
		blinker_grid[3][3] = false;

		return blinker_grid;
	}
	
	/* Returns Boat Pattern
	 * X X -
	 * X - X
     * - X -
	 */
	public static boolean[][] getBoatPattern() {
		boolean[][] boat_grid = getInitialGrid();

		boat_grid[1][1] = true;
		boat_grid[1][2] = true;
		boat_grid[1][3] = false;
		boat_grid[2][1] = true;
		boat_grid[2][2] = false;
		boat_grid[2][3] = true;
		boat_grid[3][1] = false;
		boat_grid[3][2] = true;
		boat_grid[3][3] = false;

		return boat_grid;
	}
}
