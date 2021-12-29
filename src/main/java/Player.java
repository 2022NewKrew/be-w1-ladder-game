import java.util.List;

public class Player {
	private List<String> playerList;

	public Player(List<String> playerList) {
		this.playerList = playerList;
	}

	public int getNumberOfPlayer() {
		return playerList.size();
	}

	public void printPlayer() {
		for (String player : playerList) {
			System.out.printf("%-5s ", player);
		}

		System.out.println();
	}
}
