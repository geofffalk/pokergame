package pokergame;

public class PokerMain {

	public static void main(String[] args) {
		Game g = new Game();
		g.TwoComputerPlayers();
	}
}
//private static Hand computerHand1;
//private static Hand computerHand2;
//private static Player computerPlayer1;
//private static Player computerPlayer2;
//
//public static void main(String[] args) {
//	d = Dealer.getInstance();
//	
//	computerHand1 = new Hand(d.dealFiveCards());
//	computerHand2 = new Hand(d.dealFiveCards());
//	
//	computerPlayer1 = new ComputerPlayer();
//	computerPlayer2 = new ComputerPlayer();
//	
//	computerPlayer1.setHand(computerHand1);
//	computerPlayer2.setHand(computerHand2);
//	
//	System.out.println("Computer's hand 1 is: \n\n" + computerPlayer1.showHand());
//	System.out.println("Computer's hand 2 is: \n\n" + computerPlayer2.showHand());
//	System.out.println("Analysis of computer 1's hand: "+ computerPlayer1.analyseHand());
//	System.out.println("Analysis of computer 2's hand: "+ computerPlayer2.analyseHand());
//	
//	boolean[] cardsComputer1WantsToKeep = computerPlayer1.getCardsToKeep();
//	boolean[] cardsComputer2WantsToKeep = computerPlayer2.getCardsToKeep();
//	
//	Card[] newCards1 = new Card[5];
//	int cardsToChange1 = 0;
//	for (int i = 0; i < 5; i++) {
//		if (cardsComputer1WantsToKeep[i]) {
//			newCards1[i] = computerHand1.getCard(i);
//		} else {
//			cardsToChange1++;
//			newCards1[i] = d.dealACard();
//		}
//	}
//	
//	Card[] newCards2 = new Card[5];
//	int cardsToChange2 = 0;
//	for (int i = 0; i < 5; i++) {
//		if (cardsComputer2WantsToKeep[i]) {
//			newCards2[i] = computerHand2.getCard(i);
//		} else {
//			cardsToChange2++;
//			newCards2[i] = d.dealACard();
//		}
//	}
//	Hand newComputerHand1 = new Hand(newCards1);
//	Hand newComputerHand2 = new Hand(newCards2);
//	
//	computerPlayer1.setHand(newComputerHand1);
//	computerPlayer2.setHand(newComputerHand2);
//	
//	System.out.println("\nComputer 1 has changed "+cardsToChange1+" cards.");
//	System.out.println("\nComputer 2 has changed "+cardsToChange2+" cards.");
//	
//	System.out.println("\nComputer 1's final hand is: \n\n" + computerPlayer1.showHand());
//	System.out.println("\nComputer 2's final hand is: \n\n" + computerPlayer2.showHand());
//	
//	System.out.println("Analysis of final computer 1 hand: "
//			+ computerPlayer1.analyseHand());
//	System.out.println("Analysis of final computer 2 hand: "
//			+ computerPlayer2.analyseHand());
//