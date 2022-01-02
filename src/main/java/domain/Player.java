package domain;

import java.util.List;

public class Player {
	private static final int PRINT_LIMIT = 5;
	public static final int NO_PLAYER_INDEX = -1;

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

	public int getPlayerIndex(String name) {
		for (int i = 0; i < playerList.size(); i++) {
			if (name.equals(playerList.get(i))) {
				return i * 2;
			}
		}

		return NO_PLAYER_INDEX;
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
