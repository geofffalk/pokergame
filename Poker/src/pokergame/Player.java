package pokergame;

public abstract class Player {


	protected Hand myHand;
	protected boolean[] cardsToKeep;
	protected Integer topRankingValue;
	protected Integer topRankingValue2;
	protected boolean poker;
	protected boolean threeOfAKind;
	protected boolean twoOfAKind;
	protected boolean twoPairs;
	protected boolean flush;
	protected boolean straight;
	protected String[] valueNames = new String[] { "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

	protected Player() {
		cardsToKeep = new boolean[5];
		topRankingValue = 0;
		topRankingValue2 = 0;
	}
	
	
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

	
	/**Shows the hand 
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
	
	
	
	/**Analyses the cards in the current hand and returns a status
	 * The analysis taking place will differ depending on whether it is a human or a computer analsying
	 * @return a string giving the status of the computer's hand
	 */
	protected abstract String analyseHand();
	
	/**Asks the user to check their hand and see if they wish to change cards
	 */
	
	
	

	
	
	
	

	

}