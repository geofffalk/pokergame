package pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComputerPlayer {

	private Hand myHand;
	private boolean[] cardsToKeep;
	private Integer topRankingValue;
	private Integer topRankingValue2;
	private boolean poker;
	private boolean threeOfAKind;
	private boolean twoOfAKind;
	private boolean twoPairs;
	private boolean flush;
	private boolean straight;
	private String[] valueNames = new String[] { "Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	
	public ComputerPlayer() {
cardsToKeep = new boolean[5];
topRankingValue = 0;
topRankingValue2 = 0;
	}

	public void setHand(Hand hand) {
		myHand = hand;

	}

	public Hand getHand() {
		// TODO Auto-generated method stub
		return myHand;
	}

	public String showHand() {
		return myHand.toString();
	}

	private void resetCardsToKeep(boolean keepCards) {
		for (int i = 0; i < 5; i++) {
			cardsToKeep[i] = keepCards;
		}
	}

	public String analyseHand() {
		poker = threeOfAKind = twoOfAKind = twoPairs = flush = straight = false;
		// test for flush
		if (myHand.getCardSuit(0).equals(myHand.getCardSuit(1))
				&& myHand.getCardSuit(1).equals(myHand.getCardSuit(2))
				&& myHand.getCardSuit(2).equals(myHand.getCardSuit(3))
				&& myHand.getCardSuit(3).equals(myHand.getCardSuit(4))) {
			flush = true;
			resetCardsToKeep(true);

		}
		// test for straight
		myHand.sortCardsByValue();

		if ((myHand.getCardValue(0) - myHand.getCardValue(1) == 1)
				&& (myHand.getCardValue(1) - myHand.getCardValue(2) == 1)
				&& (myHand.getCardValue(2) - myHand.getCardValue(3) == 1)
				&& (myHand.getCardValue(3) - myHand.getCardValue(4) == 1)) {

			straight = true;
			resetCardsToKeep(true);
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
				resetCardsToKeep(false);
				for (Integer i : entry.getValue()) {

					cardsToKeep[i] = true;
				}
				break;
			case 3:
				resetCardsToKeep(false);
				topRankingValue = entry.getKey();
				for (Integer i : entry.getValue()) {

					cardsToKeep[i] = true;
				}
				threeOfAKind = true;
				break;
			case 2:
				if (twoOfAKind) {
					topRankingValue2 = entry.getKey();
					for (Integer i : entry.getValue()) {
					cardsToKeep[i] = true;
					}
					twoPairs = true;
				} else {
					topRankingValue = entry.getKey();
					resetCardsToKeep(false);
					for (Integer i : entry.getValue()) {

						cardsToKeep[i] = true;
					}
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

	public boolean[] getCardsToKeep() {
		return cardsToKeep;
	}

}
