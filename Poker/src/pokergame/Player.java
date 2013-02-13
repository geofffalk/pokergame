package pokergame;

public interface Player {

	/**Sets the Computer's Hand to given hand 
	 * @param hand, the given hand
	 */
	public abstract void setHand(Hand hand);

	/**Checks the Computer's hand 
	 * @return myHand, hand the computer is holding
	 */
	public abstract Hand getHand();

	/**Shows the hand of the computer
	 * @return myHand the computer's hand in string format. 
	 */
	public abstract String showHand();

	/**Analyses the cards in the current hand and returns a status 
	 * @return a string giving the status of the computer's hand
	 */
	public abstract String analyseHand();

	/**Gets the cards to keep
	 * @return cardsToKeep[], an array of booleans that whether each card in a hand should be kept or not
	 */
	public abstract boolean[] getCardsToKeep();

}