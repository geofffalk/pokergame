package test;

import static org.junit.Assert.*;

import org.junit.Test;

import pokergame.Card;

public class CardTest {

	@Test
	public void test() {
		String expectedOutput = "King of clubs";
		Card card = new Card(13,"clubs");
		String actualOutput = card.toString();
		assertEquals("Wrong!",expectedOutput, actualOutput);
	}

}
