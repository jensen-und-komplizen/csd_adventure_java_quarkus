package de.derkomischeagilist;

public class Inventory {
	private Inventory() {}

	private static int coins = 0;

	public static int getCoins() {
		return coins;
	}

	public static void addCoin() {
		Inventory.coins += 1;
	}

	public static void clear() {
		Inventory.coins = 0;
	}
}
