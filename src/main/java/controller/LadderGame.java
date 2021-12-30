package controller;

import domain.Ladder;
import domain.Player;
import util.Message;

public class LadderGame {
	private final Player player;
	private final Ladder ladder;

	public LadderGame(Player player, Ladder ladder) {
		this.player = player;
		this.ladder = ladder;
	}

	public void printLadderGame() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n" + Message.LADDER_RESULT_MESSAGE + "\n");
		sb.append(player.printPlayer() + "\n");
		sb.append(ladder.printLadder() + "\n");

		System.out.println(sb);
	}
}
