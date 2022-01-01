package domain.generator;

import java.util.StringTokenizer;

import domain.Player;
import util.Message;

public class PlayerGenerator extends InputGenerator {
	public static Player generate() throws Exception {
		System.out.println(Message.PLAYER_INPUT_MESSAGE);
		StringTokenizer st = new StringTokenizer(BR.readLine(), ", ");

		return new Player(stringTokenizerToList(st));
	}
}
