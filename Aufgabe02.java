package uebung03;

import java.util.Arrays;

public class Aufgabe02 {
	public static int[][] data = { { 11, 8, 0 }, { 15, 12, 0 }, { 20, 13, 0 },
			{ 28, 20, 0 }, { 9, 7, 0 }, { 3, 4, 0 } };

	public static void main(String[] args) {
		pavian(10000, data);
	}

	private static void pavian(int m, int[][] data) {
		int[][] dyn = new int[m][data.length + 1];
		int smallest = 0;
		int count = 1;
		for (int[] iA : data) {
			dyn[iA[1] - 1][0] = iA[0];
			dyn[iA[1] - 1][count]++;
			count++;
		}
		for (int i = 0; i < m; i++) {
			if (dyn[i][0] != 0) {
				smallest = i;
				break;
			}
		}
		for (int i = smallest + 1; i < m; i++) {
			int[] max = dyn[i];
			for (int j = 0; j < i / 2; j++) {
				if (dyn[i - j - 1][0] + dyn[j][0] > max[0]) {
					for (int y = 0; y < data.length + 1; y++) {
						max[y] = dyn[i - j - 1][y] + dyn[j][y];
					}
				}
			}
			for (int j = 0; j < data.length + 1; j++) {
				dyn[i][j] = max[j];
			}
		}
		System.out.println(Arrays.toString(dyn[dyn.length - 1]));
	}
}
