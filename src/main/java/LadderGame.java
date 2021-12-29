import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LadderGame {
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	private Player player;
	private Ladder ladder;

	public LadderGame() {
	}

	public void start() throws Exception {
		System.out.println(Message.PLAYER_INPUT_MESSAGE);
		StringTokenizer st = new StringTokenizer(BR.readLine(), ",");
		player = new Player(stToList(st));

		System.out.println(Message.LADDER_HEIGHT_INPUT_MESSAGE);
		int ladderHeight = Integer.parseInt(BR.readLine());
		ladder = new Ladder(player.getNumberOfPlayer(), ladderHeight);

		ladder.makeLadder();
	}

	private List<String> stToList(StringTokenizer st) {
		List<String> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		return list;
	}

	public void printLadder() {
		System.out.println("\n" + Message.LADDER_RESULT_MESSAGE);
		player.printPlayer();
		ladder.printLadder();
	}
}
