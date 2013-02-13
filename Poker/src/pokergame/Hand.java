package pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> cards;//an arraylist of cards used for the hand

	/**Constructor sets cards arraylist
	 * @param c a card[] that is dealt by dealer
	 */
	public Hand(Card[] c) {
		cards = new ArrayList<Card>(Arrays.asList(c));
	}

	
	@Override
	public String toString() {
		return  cards.get(0).toString() + "\n"
				+ cards.get(1).toString() + "\n" + cards.get(2).toString()
				+ "\n" + cards.get(3).toString() + "\n"
				+ cards.get(4).toString() + "\n";
	}

	/**Sorts the cards in a hand by suit 
	 */
	public void sortCardsBySuit() {
		Collections.sort(cards, Card.CardSuitComparator);
	}

	/**Sorts the cards in a hand by value
	 */
	public void sortCardsByValue() {
		Collections.sort(cards);
	}
	
	/**Checks the card
	 * @param i index value of the card in the array
	 * @return 
	 */
	public Card getCard(int i){
		return cards.get(i);
	}

	/**Checks the suit of a card
	 * @param i index value of the card in the array
	 * @return string value for the suit for the card
	 */
	public String getCardSuit(int i) {
		return cards.get(i).getSuit();
	}

	/**Checks the value of a card
	 * @param i index value of the card in the array
	 * @return an int value for the card
	 */
	public int getCardValue(int i) {
		return cards.get(i).getValue();
	}

	public void discardCard (int i) {
	}
	


}
