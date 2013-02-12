package pokergame;



public class PokerMain {
	private static Dealer d;
	private static Hand computerHand;
	private static ComputerPlayer computerPlayer;

	public static void main(String[] args) {
		d = Dealer.getInstance();
		computerHand = new Hand(d.dealFiveCards());
		computerPlayer = new ComputerPlayer();
		computerPlayer.setHand(computerHand);
		System.out.println("Computer's hand is: \n\n" + computerPlayer.showHand());
		System.out.println("Analysis of computer's hand: "
				+ computerPlayer.analyseHand());
		boolean[] cardsComputerWantsToKeep = computerPlayer.getCardsToKeep();
		Card[] newCards = new Card[5];
		int cardsToChange = 0;
		for (int i = 0; i < 5; i++) {
			if (cardsComputerWantsToKeep[i]) {
				newCards[i] = computerHand.getCard(i);
			} else {
				cardsToChange++;
				newCards[i] = d.dealACard();
			}
		}
		Hand computerHand2 = new Hand(newCards);
		computerPlayer.setHand(computerHand2);
		System.out.println("\nComputer has changed "+cardsToChange+" cards.");
		System.out.println("\nComputer's final hand is: \n\n" + computerPlayer.showHand());
		
		System.out.println("Analysis of final computer's hand: "
				+ computerPlayer.analyseHand());
		
	}
}
