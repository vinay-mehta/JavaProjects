/**
 * 
 */
package com.tw.main;

import java.util.Scanner;

import com.tw.sampledata.SamplePatternData;

/**
 * @author vinaymehta
 * 
 */
public class MainTest {

	public static void main(String args[]) {

		Scanner console = new Scanner(System.in);
		System.out.println("Enter 1 for Block Pattern, 2 for toad Pattern, 3 for Blinker Pattern, 4 for Boat Pattern : ");

		int num = console.nextInt();
		boolean[][] grid = null;

		switch (num) {
		case 1:
			grid = SamplePatternData.getBlockPattern();
			break;
		case 2:
			grid = SamplePatternData.getToadPattern();
			break;
		case 3:
			grid = SamplePatternData.getBlinkerPattern();
			break;
		case 4:
			grid = SamplePatternData.getBoatPattern();
			break;
		}

		// print initial Pattern Selected by User
		PlayGameOfLife playGame = new PlayGameOfLife(grid);

		playGame.play();
		// process the pattern
	}
}
