package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import pokergame.HumanPlayer;
import pokergame.Dealer;
import pokergame.Hand;
import pokergame.Player;

public class HumanPlayerTest {

	private Dealer d;
	private Hand humanHand;
	private Player humanPlayer;

	@Before
	public void setUp() throws Exception {
		d = Dealer.getInstance();
		humanHand = new Hand(d.dealFiveCards());
		humanPlayer = new HumanPlayer();
	}
	
	
	@Test
	public void test() {
		humanPlayer.setHand(humanHand);
		String humanHand = humanPlayer.showHand();
		String expectedOutput = "I cant predict this...";
		String actualOutput = humanPlayer.showHand();
		assertEquals("Wrong!",expectedOutput, actualOutput);

		
	}
	

	
	

}
