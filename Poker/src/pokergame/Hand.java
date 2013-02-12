package pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand {

	/**
	 * @param args
	 */
	private ArrayList<Card> cards;

	public Hand(Card[] c) {
		cards = new ArrayList<Card>(Arrays.asList(c));
		// set initial card worth to the value of the card
	}

	@Override
	public String toString() {
		return  cards.get(0).toString() + "\n"
				+ cards.get(1).toString() + "\n" + cards.get(2).toString()
				+ "\n" + cards.get(3).toString() + "\n"
				+ cards.get(4).toString() + "\n";
	}

	public void sortCardsBySuit() {
		Collections.sort(cards, Card.CardSuitComparator);
	}

	public void sortCardsByValue() {
		Collections.sort(cards);
	}
	
	public Card getCard(int i){
		return cards.get(i);
	}

	public String getCardSuit(int i) {

		return cards.get(i).getSuit();
	}

	public int getCardValue(int i) {

		return cards.get(i).getValue();
	}

	public void discardCard (int i) {
		
		
	}
	


}
