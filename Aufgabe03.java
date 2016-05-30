package uebung03;

public class Aufgabe03 {

	private static int counter = 0;

	public static void main(String[] args) {
		System.out.println(mysterious(10, 3));
		System.out.println(counter);
	}

	private static int mysterious(int a, int b) {
		counter++;
		if (a == b) {
			return a;
		} else {
			if (a < b) {
				if (b - a == 1) {
					return a;
				} else {
					return mysterious(a + 1, b - 1);
				}
			} else {
				if (a - b == 1) {
					return b;
				} else {
					return mysterious(a - 1, b + 1);
				}
			}
		}
	}
}