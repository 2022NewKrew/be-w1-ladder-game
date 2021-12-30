package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	Player player;

	List<String> playerList;

	@BeforeEach
	void setUp() {
		playerList = new ArrayList<>();
		player = new Player(playerList);
	}

	@Test
	@DisplayName("PlayerList Get 테스트")
	void getNumberOfPlayerTest() {
		//given
		int expected = player.getPlayerList().size();

		//when
		int result = player.getNumberOfPlayer();

		//then
		assertEquals(expected, result);
	}

	@Test
	@DisplayName("Player 출력 테스트")
	void printPlayerTest() {
		//given
		String name1 = "abc";
		String name2 = "hi";
		player.getPlayerList().add(name1);
		player.getPlayerList().add(name2);

		int expected = name1.length() + name2.length();

		//when
		int result = player.printPlayer().replaceAll(" ", "").length();

		//then
		assertEquals(expected, result);

	}

	@Test
	@DisplayName("글자제한 넘어가는 Player 출력 테스트")
	void printPlayerTest_longName() {
		//given
		String longName1 = "abcdefg";
		String longName2 = "hijklm";
		player.getPlayerList().add(longName1);
		player.getPlayerList().add(longName2);

		int expected = 10;

		//when
		int result = player.printPlayer().replaceAll(" ", "").length();

		//then
		assertEquals(expected, result);
	}
}