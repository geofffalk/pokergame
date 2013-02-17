package pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Player {

	protected Hand myHand;
	protected boolean[] cardsToKeep;
	protected Integer topRankingValue;
	protected Integer topRankingValue2;
	protected boolean twoOfAKind;
	protected boolean flush;
	protected boolean straight;
	protected String matchingCards ="";
	protected String[] valueNames = new String[] { "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
	protected Map<Integer, ArrayList<Integer>> cardMap;

	protected Player() {
		cardsToKeep = new boolean[5];
		topRankingValue = 0;
		topRankingValue2 = 0;
	}
	
	/**Checks what cards the player wishes to swap
	 * The implementation of this method will differ depending on the whether it is for human ot 
	 */
	protected abstract void SwapCardChoice();
	
	/**Sets the Hand to given hand 
	 * @param hand, the given hand
	 */
	protected void setHand(Hand hand){
		myHand = hand;
	}
	
		
	/**Checks the hand 
	 * @return myHand, hand the computer is holding
	 */
	protected Hand getHand(){
		return myHand;
	}

	
	/**Displays the hand to the screen
	 * @return myHand in string format. 
	 */
	protected String showHand(){
		return myHand.toString();
	}
	
	
	/**Checks the total score of a hand (based on card value) 
	 * This is used to differentiate in the case where both players 
	 * have the same type of hands (both have flushes)
	 * @param finalHand the given hand 
	 * @return score an int value that shows an overall value for the card values
	 */
	protected int getHandScore(Hand finalHand){
	int score = (myHand.getCardValue(0)+myHand.getCardValue(1)+myHand.getCardValue(2)
			+myHand.getCardValue(3)+myHand.getCardValue(4));
	return score;
	}
	
	
	/**Uses a boolean to establish whether a card should be kept or not
	 * @param keepCards given boolean when it set to true the card is kept
	 */
	protected void resetCardsToKeep(boolean keepCards) {
		for (int i = 0; i < 5; i++) {
			cardsToKeep[i] = keepCards;
		}
	}
	
	
	/**Gets the cards to keep
	 * @return cardsToKeep[], an array of booleans that whether each card in a hand should be kept or not
	 */
	protected boolean[] getCardsToKeep(){
		return cardsToKeep;
	}
	
	
	/**Analyses the cards in the current hand checking for various potential status
	 * @return a string giving the status of the computer's hand
	 */
	protected String AnalyseHand(){
		flush = checkFlush(myHand);
		straight = checkStraight(myHand);
		cardMap = setCardMap(myHand);
		matchingCards = checkMatching(cardMap);
		String finalStatus = getFinalStatus(myHand);
		return finalStatus;
	}


	/**Checks for a flush in the given hand
	* @param myHand, the given hand
	* @return flush true if flush found
	*/
	protected boolean checkFlush(Hand myHand){
		flush = false;
		if (myHand.getCardSuit(0).equals(myHand.getCardSuit(1))
			&& myHand.getCardSuit(1).equals(myHand.getCardSuit(2))
			&& myHand.getCardSuit(2).equals(myHand.getCardSuit(3))
			&& myHand.getCardSuit(3).equals(myHand.getCardSuit(4))) {
			flush = true;
		}
		else
		{
			flush = false;
		}
			return flush;
	}

	
	/**Checks for a straight in the given hand
	 * @param myHand, the given hand
	 * @return straight true if flush found
	*/
	public boolean checkStraight(Hand myHand){
			straight=false;	
			myHand.sortCardsByValue();
			if ((myHand.getCardValue(0) - myHand.getCardValue(1) == 1)
					&& (myHand.getCardValue(1) - myHand.getCardValue(2) == 1)
					&& (myHand.getCardValue(2) - myHand.getCardValue(3) == 1)
					&& (myHand.getCardValue(3) - myHand.getCardValue(4) == 1)) {
				straight = true;
			}
			else{
				straight = false;
			}
			return straight;
	}

	
	/**Creates a hash map showing how many cards of each value are in the hand
	 * @param myHand, the given hand
	 * @return cardMap, the hash map for the given hand 
	 */
	protected Map<Integer, ArrayList<Integer>> setCardMap(Hand myHand){
		Map<Integer, ArrayList<Integer>> cardMap = new HashMap<>();
		int counter = 1;
		while (counter < 14) {
			cardMap.put(counter, new ArrayList<Integer>());
			counter++;
		}
		counter = 0;
		while (counter < 5) {
			cardMap.get(myHand.getCardValue(counter)).add(counter);
			counter++;
		}
		counter = 0;
		return cardMap;
		}

	
	/**Checks for a matching cards in the hand such as two pairs or three of a kind 
	 * @param cardMap, a hashmap showing how many cards of each value are in the hand
	 * @return finalStatus, a string value that gives the status
	 */
	public String checkMatching(Map<Integer, ArrayList<Integer>> cardMap){
			for (Map.Entry<Integer, ArrayList<Integer>> entry : cardMap.entrySet()) {
				switch (entry.getValue().size()) {
				case 4:
					topRankingValue = entry.getKey();
					matchingCards = "four of a Kind";
					break;
				case 3:
					topRankingValue = entry.getKey();
					matchingCards = "three of a Kind";
					break;
				case 2:
					if (twoOfAKind) {
						topRankingValue2 = entry.getKey();
						matchingCards = "two pair";
					} else {
						topRankingValue = entry.getKey();
						twoOfAKind = true;
						matchingCards = "a pair";
					}
				}
			}
			return matchingCards;
	}
			

/**Gets the correct string to correspond with the hand in question
 * @param myHand
 * @return String exclaiming the value of the cards
 */
public String getFinalStatus(Hand myHand){
if (straight && flush) {
	return "GOT A STRAIGHT FLUSH !! ";
} else if (flush) {
	return "GOT A FLUSH!!";
} else if (straight) {
	return "GOT A STRAIGHT!!";
} else if ((matchingCards.equals("four of a Kind"))||(matchingCards.equals("three of a Kind"))||(matchingCards.equals("a pair"))){ 
	return "GOT " + (matchingCards +" of " + valueNames[topRankingValue-1] + "s").toUpperCase();
} else if (matchingCards.equals("two pair")){
	return "GOT TWO PAIRS OF "+ (valueNames[topRankingValue-1] + "s and "+ valueNames[topRankingValue2-1] + "s").toUpperCase();
} else {
	return "GOT NOTHING";
}

}
/**Assigns a value to the hand so that a winner can be evaluated
 * @param s
 * @return bestHand, the hand's basic score
 */
public int evaluateHand(String s){
	int bestHand;
	if (s.startsWith("GOT A STRAIGHT FLUSH !! ")){
		bestHand = 1000;
	} else if (s.startsWith("GOT FOUR OF A KIND")){
		bestHand = 900;
	} else if (s.startsWith("GOT A FLUSH!!")){
		bestHand = 800;
	} else if (s.startsWith("GOT A STRAIGHT!!")) {
		bestHand = 700;
	} else if (s.startsWith("GOT THREE OF A KIND OF")) {
		bestHand = 600;
	} else if (s.startsWith("GOT TWO PAIRS OF ")) {
		bestHand = 500;
	} else if (s.startsWith("GOT A PAIR OF ")){
		bestHand = 400;
	} else {
		bestHand = 0;
	}
	return bestHand;
}



	
	
}
	

