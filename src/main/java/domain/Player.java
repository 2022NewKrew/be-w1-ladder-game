package domain;

import java.util.List;

public class Player {
	private static final int PRINT_LIMIT = 5;

	private final List<String> playerList;

	public Player(List<String> playerList) {
		this.playerList = playerList;
	}

	public List<String> getPlayerList() {
		return playerList;
	}

	public int getNumberOfPlayer() {
		return playerList.size();
	}

	public String printPlayer() {
		StringBuilder sb = new StringBuilder();

		for (String player : playerList) {
			sb.append(
				String.format("%-5s ", player.length() > PRINT_LIMIT ? player.substring(0, PRINT_LIMIT) : player)
			);
		}

		return sb.toString();
	}
}
