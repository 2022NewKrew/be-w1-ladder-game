package domain.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import domain.Player;
import domain.generator.InputGenerator;
import util.Message;

public class PlayerGenerator extends InputGenerator {
	public static Player generate() throws Exception {
		System.out.println(Message.PLAYER_INPUT_MESSAGE);
		StringTokenizer st = new StringTokenizer(BR.readLine(), ", ");

		return new Player(stringTokenizerToList(st));
	}

	private static List<String> stringTokenizerToList(StringTokenizer st) {
		List<String> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		return list;
	}
}
