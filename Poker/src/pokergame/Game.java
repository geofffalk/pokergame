package pokergame;

public class Game{
	private static Dealer d;
	private static Hand computerHand;
	private static Hand humanHand;
	private static Player computerPlayer;
	private static Player humanPlayer;

	public void ComputerVersusHuman() {
		d = Dealer.getInstance();
		
		computerHand = new Hand(d.dealFiveCards());
		humanHand = new Hand(d.dealFiveCards());
		
		computerPlayer = new ComputerPlayer();
		humanPlayer = new HumanPlayer();
		
		computerPlayer.setHand(computerHand);
		humanPlayer.setHand(humanHand);
		
		System.out.println("Computer's hand is: \n\n" + computerPlayer.showHand());
		System.out.println("Your hand is: \n\n" + humanPlayer.showHand());
		
		//System.out.println("Analysis of computer's hand so far: "+ computerPlayer.analyseHand());
		((HumanPlayer) humanPlayer).checkUserChoice();
		
		boolean[] cardsComputerWantsToKeep = computerPlayer.getCardsToKeep();
		boolean[] cardsHumanWantsToKeep = humanPlayer.getCardsToKeep();
		
		Card[] newComputerCards = new Card[5];
		int cardsToChange1 = 0;
		for (int i = 0; i < 5; i++) {
			if (cardsComputerWantsToKeep[i]) {
				newComputerCards[i] = computerHand.getCard(i);
			} else {
				cardsToChange1++;
				newComputerCards[i] = d.dealACard();
			}
		}
		
		Card[] newHumanCards = new Card[5];
		int cardsToChange2 = 0;
		for (int i = 0; i < 5; i++) {
			if (cardsHumanWantsToKeep[i]) {
				newHumanCards[i] = humanHand.getCard(i);
			} else {
				cardsToChange2++;
				newHumanCards[i] = d.dealACard();
			}
		}
	
		computerPlayer.setHand(computerHand);
		humanPlayer.setHand(humanHand);
		
		System.out.println("\nComputer has changed "+cardsToChange1+" cards.");
		System.out.println("\nYou changed "+cardsToChange2+" cards.");
		
		System.out.println("\nComputer's final hand is: \n\n" + computerPlayer.showHand());
		System.out.println("\nYour final hand is: \n\n" + humanPlayer.showHand());
		
		String finalHand1 = computerPlayer.analyseHand();
		String finalHand2 = humanPlayer.analyseHand();
		
		System.out.println("Computer's final analysis: " + finalHand1);
		System.out.println("Your final analysis: " + finalHand2);
		
		int final1 = evaluateFinalHand(finalHand1);
		int final2 = evaluateFinalHand(finalHand2);
		
		if(final1<final2){
			System.out.println("THE COMPUTER HAS WON!!");
		}
		else if(final2 < final1)
		{
			System.out.println("YOU WON!!!");
		}
		else if(final1 == final2)
		{
			int computerScore = computerPlayer.getHandScore(computerHand);
			int humanScore = humanPlayer.getHandScore(humanHand);
			
		 	if(computerScore > humanScore){
		 		System.out.println("THE COMPUTER HAS WON, BUT IT WAS CLOSE!!");
		 	}
		 	else if(computerScore < humanScore){
		 		System.out.println("YOU WON, BUT ONLY JUST!!");
		 	}
		 	else if(computerScore == humanScore){
		 		System.out.println("ITS A TIE!!");
		 	}
		}
	}
	
	/**Gives a basic score to a hand, 
	 * so that hands can be ranked and a winner established
	 * @param s the string returned in analyseHand()
	 * @return bestHand, an int value for the card
	 */
	public int evaluateFinalHand(String s){
		int bestHand;
		if (s == "I GOT A STRAIGHT FLUSH !! "){
			bestHand = 1;
		} else if (s.startsWith("I GOT A POKER OF")){
			bestHand = 2;
		} else if (s.startsWith("I GOT A FLUSH!!")) {
			bestHand = 3;
		} else if (s=="I GOT A STRAIGHT!!") {
			bestHand = 4;
		} else if (s.startsWith("I GOT THREE OF A KIND OF")) {
			bestHand = 5;
		} else if (s.startsWith("I GOT TWO PAIRS OF ")) {
			bestHand = 6;
		} else if (s.startsWith("I GOT A PAIR OF ")){
			bestHand = 7;
		} else {
			bestHand = 8;
		}
		return bestHand;
	
	}
	
	}

//private static Hand computerHand1;
//private static Hand computerHand2;
//private static Player computerPlayer1;
//private static Player computerPlayer2;
//private String finalHand1;
//private String finalHand2;

//
///**Runs a game with two computer players
// */
//public void TwoComputerPlayers() {
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
//	
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
//	String finalHand1 = computerPlayer1.analyseHand();
//	String finalHand2 = computerPlayer2.analyseHand();
//	
//	int final1 = evaluateFinalHand(finalHand1);
//	int final2 = evaluateFinalHand(finalHand2);
//	
//	System.out.println("Analysis of final computer 1 hand: " + finalHand1);
//	System.out.println("Analysis of final computer 2 hand: " + finalHand2);
//	
//	//NEED TO BE ABLE TO COMPARE TWO PAIRS 
//	if(final1<final2){
//		System.out.println("The winner is player 1!");
//	}
//	else if(final2 < final1)
//	{
//		System.out.println("The winner is player 2!");
//	}
//	else{
//		System.out.println("Its a draw!");
//	}
//}
//

