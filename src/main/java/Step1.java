import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Step1 {
	private static final char VERTICAL_LINE = '|';
	private static final char HORIZONTAL_LINE = '-';
	private static final char EMPTY = ' ';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("참여할 사람은 몇 명인가요?");
		int numberOfPeople = Integer.parseInt(br.readLine());

		System.out.println("최대 사다리 높이는 몇 개인가요?");
		int ladderHeight = Integer.parseInt(br.readLine());

		List[] ladder = getLadder(numberOfPeople, ladderHeight);
		printLadder(ladder);
	}

	static List[] getLadder(int numberOfPeople, int ladderHeight) {
		List<Character>[] ladder = new ArrayList[ladderHeight];

		for (int height = 0; height < ladderHeight; height++) {
			ladder[height] = new ArrayList<>();

			for (int person = 0; person < numberOfPeople; person++) {
				ladder[height].add(VERTICAL_LINE);
				ladder[height].add(getRandomCross(person, numberOfPeople));
			}
		}

		return ladder;
	}

	static char getRandomCross(int person, int numberOfPeople) {
		if (person == numberOfPeople - 1) {
			return EMPTY;
		}

		int random = (int)(Math.random() * 10);

		return random % 2 == 0 ? EMPTY : HORIZONTAL_LINE;
	}

	static void printLadder(List[] ladder) {
		int ladderHeight = ladder.length;

		for (int height = 0; height < ladderHeight; height++) {
			for (Object ch : ladder[height]) {
				System.out.print((Character)ch);
			}

			System.out.println();
		}
	}
}
