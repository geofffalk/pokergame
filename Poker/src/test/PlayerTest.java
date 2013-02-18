package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import pokergame.Card;
import pokergame.ComputerPlayer;
import pokergame.Hand;
import pokergame.Player;

public class PlayerTest {

private Hand computerHand;
private Player computerPlayer;


	@Before
	public void setUp() throws Exception {
		Card c1 = new Card(13,"clubs");
		Card c2 = new Card(13,"hearts");
		Card c3 = new Card(10,"diamonds");
		Card c4 = new Card(10,"clubs");
		Card c5 = new Card(9,"clubs");
		
		Card[] testCards = {c1, c2, c3, c4, c5};
		computerHand = new Hand(testCards);
		computerPlayer = new ComputerPlayer();
	}
	
	@Test
	public void testShowHand() {
		computerPlayer.setHand(computerHand);
		computerPlayer.showHand();
		String expectedOutput = "1 " + "Ace of clubs" + "\n"+ "2 " + "Ace of hearts" + "\n"+ "3 " + "Jack of diamonds" + "\n"+ 
				"4 "+ "Jack of clubs" + "\n"+ "5 " + "Ten of clubs" + "\n";
		String actualOutput = computerPlayer.showHand();
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}	
	
	@Test
	public void testGetHandScore(){
		int expectedOutput = 55;
		int actualOutput = computerPlayer.getHandScore(computerHand);
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}
	
	@Test
	public void testResetCardsToKeep(){
		String expectedOutput = "[true, true, true, true, true]";
		computerPlayer.getCardsToKeep();
		computerPlayer.resetCardsToKeep(true);
		String actualOutput = Arrays.toString(computerPlayer.getCardsToKeep());
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}

	@Test
	public void AnalyseHand(){
		String expectedOutput = "GOT TWO PAIRS OF JACKS AND ACES";
		computerPlayer.setHand(computerHand);
		String actualOutput = computerPlayer.AnalyseHand();
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}
	
	@Test
	public void testEvaluateHand(){
		int expectedOutput = 500;
		computerPlayer.setHand(computerHand);
		int actualOutput = computerPlayer.evaluateHand(computerPlayer.AnalyseHand());
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}
	
	@Test
	public void testCheckFlush(){
		Boolean expectedOutput = false;
		computerPlayer.setHand(computerHand);
		Boolean actualOutput = computerPlayer.checkFlush(computerHand);
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}
	
	@Test
	public void testCheckStraight(){
		Boolean expectedOutput = false;
		computerPlayer.setHand(computerHand);
		Boolean actualOutput = computerPlayer.checkStraight(computerHand);
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}

	@Test
	public void testCheckMatching(){
		String expectedOutput = "two pair";
		computerPlayer.setHand(computerHand);
		String actualOutput = computerPlayer.checkMatching(computerPlayer.getCardMap(computerHand));
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}
	

}

