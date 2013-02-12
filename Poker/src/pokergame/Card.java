package pokergame;

import java.util.Comparator;

public class Card implements Comparable<Card> {


	/**
	 * @param args
	 */
	private String suit;
	private int value;
	private String[] valueNames;

	public Card(int v, String s) {
		if (s.equals("spades") || s.equals("diamonds") || s.equals("clubs")
				|| s.equals("hearts")) {
			this.setSuit(s);
		}
		if (v > 0 && v < 14) {
			this.setValue(v);
		}
		valueNames = new String[] { "Ace", "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

	}

	public String toString() {
//	return value + ": " + valueNames[value - 1] + " of " + suit;
		return valueNames[value - 1] + " of " + suit;

	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Card o) {
		int compareValue = ((Card) o).getValue();
		return this.getValue() - compareValue;

	}

	public static Comparator<Card> CardSuitComparator = new Comparator<Card>() {

		public int compare(Card card1, Card card2) {

			String cardSuit1 = card1.getSuit().toLowerCase();
			String cardSuit2 = card2.getSuit().toLowerCase();
			return cardSuit2.compareTo(cardSuit1);

		}

	};

}
