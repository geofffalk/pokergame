package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;



import pokergame.ComputerPlayer;
import pokergame.Dealer;
import pokergame.Hand;
import pokergame.Player;



public class ComputerPlayerTest {

	private Dealer d;
	private Hand computerHand;
	private Player computerPlayer;

	@Before
	public void setUp() throws Exception {
		d = Dealer.getInstance();
		computerHand = new Hand(d.dealFiveCards());
		computerPlayer = new ComputerPlayer();
	}
	
	
	@Test
	public void test() {
		computerPlayer.setHand(computerHand);
		String computersHand = computerPlayer.showHand();
		String expectedOutput = "hahahahahahah";
		String actualOutput = computerPlayer.showHand();
		assertEquals("Wrong!",expectedOutput, actualOutput);

		
	}
	

	
	

}
