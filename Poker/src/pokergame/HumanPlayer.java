package pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HumanPlayer extends Player {

 /**Asks the user which cards he/she wishes to change
 */
protected void checkUserChoice() {
		System.out.println("Please enter the numbers of the cards you wish to keep for example: 1,3");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		resetCardsToKeep(false);
		for (int i = 0;i < input.length(); i++){
			if(Character.isDigit(input.charAt(i))) {
				int cardNumber = Character.getNumericValue(input.charAt(i)-1);
		    	cardsToKeep[cardNumber] = true;
		     }
		}
	}

	/* (non-Javadoc)
	 * @see pokergame.Player#analyseHand()
	 */
	@Override
	public String analyseHand() {
	poker = threeOfAKind = twoOfAKind = twoPairs = flush = straight = false;
		// test for flush (same suit)
		if (myHand.getCardSuit(0).equals(myHand.getCardSuit(1))
				&& myHand.getCardSuit(1).equals(myHand.getCardSuit(2))
				&& myHand.getCardSuit(2).equals(myHand.getCardSuit(3))
				&& myHand.getCardSuit(3).equals(myHand.getCardSuit(4))) {
			flush = true;
			}
			// test for straight
			myHand.sortCardsByValue();
	
			if ((myHand.getCardValue(0) - myHand.getCardValue(1) == 1)
					&& (myHand.getCardValue(1) - myHand.getCardValue(2) == 1)
					&& (myHand.getCardValue(2) - myHand.getCardValue(3) == 1)
					&& (myHand.getCardValue(3) - myHand.getCardValue(4) == 1)) {
				straight = true;
			}
			// test for poker
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
			for (Map.Entry<Integer, ArrayList<Integer>> entry : cardMap.entrySet()) {
				switch (entry.getValue().size()) {
				case 4:
					poker = true;
					topRankingValue = entry.getKey();
				case 3:
					topRankingValue = entry.getKey();
					threeOfAKind = true;
					break;
				case 2:
					if (twoOfAKind) {
						topRankingValue2 = entry.getKey();
						twoPairs = true;
					} else {
						topRankingValue = entry.getKey();
						twoOfAKind = true;
					}
				}
	
			}
	
			if (straight && flush) {
				return "I GOT A STRAIGHT FLUSH !! ";
			} else if (poker) {
				return "I GOT A POKER OF "+valueNames[topRankingValue-1] + "s";
			} else if (flush) {
				return "I GOT A FLUSH!!";
			} else if (straight) {
				return "I GOT A STRAIGHT!!";
			} else if (threeOfAKind) {
				return "I GOT THREE OF A KIND OF "+valueNames[topRankingValue-1] + "s";
			} else if (twoPairs) {
				return "I GOT TWO PAIRS OF "+valueNames[topRankingValue-1] + "s and "+valueNames[topRankingValue2-1] + "s";
			} else if (twoOfAKind) {
				return "I GOT A PAIR OF "+valueNames[topRankingValue-1] + "s";
			} else {
				return "I GOT NOTHING, WAAA";
			}
	
		}
}

///* (non-Javadoc)
// * @see pokergame.Player#getCardsToKeep()
// */
//@Override
//public boolean[] getCardsToKeep() {
//	return cardsToKeep;
//}
//
///* (non-Javadoc)
// * @see pokergame.Player#setHand(pokergame.Hand)
// */
//@Override
//public void setHand(Hand hand) {
//	myHand = hand;
//}
//
///* (non-Javadoc)
// * @see pokergame.Player#getHand()
// */
//@Override
//public Hand getHand() {
//	return myHand;
//}
//
///* (non-Javadoc)
// * @see pokergame.Player#showHand()
// */
//@Override
//public String showHand() {
//	return myHand.toString();
//}
//
///* (non-Javadoc)
// * @see pokergame.Player#getHandScore(pokergame.Hand)
// */
//@Override
//public int getHandScore(Hand myHand) {
//	int score = (myHand.getCardValue(0)+myHand.getCardValue(1)+myHand.getCardValue(2)
//			+ myHand.getCardValue(3)+myHand.getCardValue(4));
//	return score;
//}
//
///**Uses a boolean to establish whether a card should be kept or not
// * @param keepCards given boolean when it set to true the card is kept
// */
//protected void resetCardsToKeep(boolean keepCards) {
//	for (int i = 0; i < 5; i++) {
//		cardsToKeep[i] = keepCards;
//	}
//}


