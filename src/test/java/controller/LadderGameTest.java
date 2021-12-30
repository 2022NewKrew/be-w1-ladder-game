package controller;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Ladder;
import domain.Player;

class LadderGameTest {
	LadderGame ladderGame;

	Player player;
	Ladder ladder;

	@BeforeEach
	void setUp() {
		player = mock(Player.class);
		ladder = mock(Ladder.class);

		ladderGame = new LadderGame(player, ladder);
	}

	@Test
	@DisplayName("LadderGame 출력 테스트")
	void printLadderGameTest() {
		//given
		String emptyPlayer = "";
		String emptyLadder = "";
		when(player.printPlayer()).thenReturn(emptyPlayer);
		when(ladder.printLadder()).thenReturn(emptyLadder);

		//when
		ladderGame.printLadderGame();

		//then
		verify(player, times(1)).printPlayer();
		verify(ladder, times(1)).printLadder();
	}
}