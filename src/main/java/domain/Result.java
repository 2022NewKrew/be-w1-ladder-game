package domain;

import java.util.List;

public class Result {
	private static final String END_CODE = "춘식이";

	private final List<String> resultList;

	public Result(List<String> resultList) {
		this.resultList = resultList;
	}

	public String printResult() {
		StringBuilder sb = new StringBuilder();

		for (String result : resultList) {
			sb.append(String.format("%-5s ", result));
		}

		return sb.toString();
	}

	public String getPlayerResult(int playerIndex) {
		playerIndex = playerIndex / 2;

		return resultList.get(playerIndex);
	}
}
