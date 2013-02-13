package pokergame;

import java.util.Collections;
import java.util.Stack;

public class Dealer {
	Stack<Card> pack;
	static Dealer instance;

	/**Constructor, sets a new pack
	 */
	private Dealer() {
		newPack();
	}

	/**Creates a new stack of cards with all cards and shuffles the cards
	 */
	public void newPack() {
		pack = new Stack<Card>();
		String[] suits = new String[] { "hearts", "clubs", "diamonds", "spades" };
		Integer[] values = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13};
		for (String s : suits) {
			for (Integer v : values) {
				Card c = new Card(v, s);
				pack.add(c);
			}
		}
		shuffle();
	}

	/**Allows the Dealer class to create a new instance of dealer
	 * @return instance a new instance of Dealer class
	 */
	public static Dealer getInstance() {
		if (instance == null) {
			instance = new Dealer();
		}
		return instance;
	}

	/**Shuffles the pack of cards into a random order
	 */
	public void shuffle() {
		Collections.shuffle(pack);
	}

	/**Deals a card from the top of the stack of cards
	 * @return a card from the top of the pack
	 */
	public Card dealACard() {
		return pack.pop();
	}
	
	/**Deals five cards from the top of the stack of cards
	 * @return Card[] an array of 5 cards that will be used for a hand
	 */
	public Card[] dealFiveCards() {
		return new Card[] {pack.pop(), pack.pop(), pack.pop(), pack.pop(),
							pack.pop() };
	}
}
