package domain.generator;

import java.util.StringTokenizer;

import domain.Result;
import util.Message;

public class ResultGenerator extends InputGenerator {
	public static Result generate() throws Exception {
		System.out.println(Message.RESULT_INPUT_MESSAGE);
		StringTokenizer st = new StringTokenizer(BR.readLine(), ", ");

		return new Result(stringTokenizerToList(st));
	}
}
