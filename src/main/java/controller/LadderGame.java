package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import domain.Ladder;
import domain.Player;
import domain.Result;
import util.Message;

public class LadderGame {
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	private final Player player;
	private final Ladder ladder;
	private final Result result;

	public LadderGame(Player player, Ladder ladder, Result result) {
		this.player = player;
		this.ladder = ladder;
		this.result = result;

	}

	public void printLadderGame() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n" + Message.LADDER_RESULT_MESSAGE + "\n");
		sb.append(player.printPlayer() + "\n");
		sb.append(ladder.printLadder());
		sb.append(result.printResult() + "\n");

		System.out.println(sb);
	}

	public void startLadderGame() throws Exception {
		while (true) {
			System.out.println(Message.PLAYER_RESULT_MESSAGE);

			String name = BR.readLine();

			if (name.equals("춘식이")) {
				System.out.println("\n" + Message.LADDER_GAME_END_MESSAGE);
				return;
			} else if (name.equals("all")) {
				printAllPlayerResult();
			} else {
				printPlayerResult(name);
			}
		}
	}

	private void printAllPlayerResult() {
		List<String> playerList = player.getPlayerList();

		for (String playerName : playerList) {
			int playerIndex = player.getPlayerIndex(playerName);
			System.out.println(playerName + " : " + getPlayerLadderResult(playerIndex));
		}

		System.out.println();
	}

	private void printPlayerResult(String name) {
		int playerIndex = player.getPlayerIndex(name);

		System.out.println("\n" + Message.PLAYER_GAME_RESULT);
		System.out.println(getPlayerLadderResult(playerIndex));
		System.out.println();
	}

	private String getPlayerLadderResult(int playerIndex) {
		int resultIndex = ladder.goLadder(playerIndex);

		return result.getPlayerResult(resultIndex);
	}
}
