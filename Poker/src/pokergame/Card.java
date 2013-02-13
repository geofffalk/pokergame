package pokergame;

import java.util.Comparator;

public class Card implements Comparable<Card> {

	private String suit;//The suit of a card
	private int value;//The value of a card
	private String[] valueNames; //An array of value names for the cards

	/**A constructor that sets the value and suit of a card 
	 * @param v given value for a card
	 * @param s given suit of a card
	 */
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
		return valueNames[value - 1] + " of " + suit;
	}

	/**Checks the suit of a card
	 * @return suit, a string value for the suit of a card
	 */
	public String getSuit() {
		return suit;
	}

	/**Sets the suit of a card
	 * @param suit, a string value for the suit of a card
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**Checks the value of a card
	 * @return value, an int value for the card number
	 */
	public int getValue() {
		return value;
	}

	/**Sets the value of a card
	 * @param value, an int value for the card number
	 */
	public void setValue(int value) {
		this.value = value;
	}


	@Override
	public int compareTo(Card o) {
		int compareValue = ((Card) o).getValue();
		return this.getValue() - compareValue;
	}

	public static Comparator<Card> CardSuitComparator = new Comparator<Card>() {

		/**Compares the suits of two cards
		 * @param card1
		 * @param card2
		 * @return an int value for the result of the comparison
		 */
		public int compare(Card card1, Card card2) {
			String cardSuit1 = card1.getSuit().toLowerCase();
			String cardSuit2 = card2.getSuit().toLowerCase();
			return cardSuit2.compareTo(cardSuit1);

		}

	};

}
