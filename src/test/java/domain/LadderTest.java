package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderTest {
	Ladder ladder;

	int numberOfPlayer;
	int ladderHeight;

	@BeforeEach
	void setUp() {
		numberOfPlayer = 4;
		ladderHeight = 5;

		ladder = new Ladder(numberOfPlayer, ladderHeight);
	}

	@Test
	void makeLadderTest() {
		//given
		int expected = ladder.getLadderHeight();

		//when
		ladder.makeLadder();

		//then
		int result = ladder.getRowList().size();
		assertEquals(expected, result);
	}
}