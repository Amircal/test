package uebung03;

import java.awt.Point;
import java.util.Arrays;

public class Aufgabe01 {
	public static int[][] moves = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 },
			{ -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 } };
	public static boolean[][] feld = new boolean[6][6];
	public static int counter=0;

	public static void main(String[] args) {
		Point start = new Point(0, 0);
		feld[0][0] = true;
		rek(start);
		printFeld();
		System.out.println(counter);
	}

	public static void rek(Point p) {
		for (int i = 0; i < 8; i++) {
			Point newP = new Point(p.x + moves[i][0], p.y + moves[i][1]);
			if (newP.x >= 0 && newP.x < feld.length && newP.y >= 0
					&& newP.y < feld.length) {
				if (!feld[newP.y][newP.x]) {
					feld[newP.y][newP.x] = true;
					rek(newP);
				}
				if (isSolved()) {
					counter++;
					feld[p.y][p.x] = false;
				}
			}
		}
		if (p.x == 0 && p.y == 0) {
			System.out.println("no solution");
			return;
		}
		feld[p.y][p.x] = false;
	}

	public static boolean isSolved() {
		for (boolean[] bA : feld) {
			for (boolean b : bA) {
				if (!b) {
					return false;
				}
			}
		}
		return true;
	}

	public static void printFeld() {
		for (boolean[] bA : feld) {
			System.out.println(Arrays.toString(bA));
		}
		System.out.println();
	}
}
