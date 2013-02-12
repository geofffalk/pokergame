package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;



import pokergame.ComputerPlayer;
import pokergame.Dealer;
import pokergame.Hand;



public class ComputerPlayerTest {

	private Dealer d;
	private Hand computerHand;
	private ComputerPlayer computerPlayer;

	@Before
	public  void setUp() throws Exception {
		d = Dealer.getInstance();
		computerHand = new Hand(d.dealFiveCards());
		computerPlayer = new ComputerPlayer();

	}
	
	
	@Test
	public void test() {

		computerPlayer.setHand(computerHand);
		//String computersHand = computerPlayer.showHand();
		String expectedOutput = "hahahahahahah";
		String actualOutput = computerPlayer.showHand();
;
//		computerPlayer.setHand(computerHand2);
		assertEquals("Wrong!",expectedOutput, actualOutput);

		
	}
	

	
	

}
