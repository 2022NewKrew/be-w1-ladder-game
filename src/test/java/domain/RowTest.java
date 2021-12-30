package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.LadderLineStyle;

class RowTest {
	Row row;

	@BeforeEach
	void setUp() {
		row = new Row();
	}

	@Test
	@DisplayName("선을 이을 수 없는 경우, HORIZONTAL_EMPTY만을 가짐")
	void makeLineTest_unableToConnect() {
		//given
		int numberOfPlayer = 2;
		row.prevConnected();

		//when
		row.makeLine(numberOfPlayer);

		//then
		List<LadderLineStyle> result = row.getLadderLineStyleList();
		assertTrue(result.contains(LadderLineStyle.HORIZONTAL_EMPTY));
		assertFalse(result.contains(LadderLineStyle.HORIZONTAL_LINE));
	}

	@Test
	@DisplayName("선을 이을 수 있는 경우, HORIZONTAL_LINE 또는 HORIZNONTAL_LINE 둘 중 하나를 랜덤으로 가짐")
	void makeLineTest_ableToConnect() {
		//given
		int numberOfPlayer = 2;

		//when
		row.makeLine(numberOfPlayer);

		//then
		List<LadderLineStyle> result = row.getLadderLineStyleList();
		boolean isEmpty = result.contains(LadderLineStyle.HORIZONTAL_EMPTY);
		boolean isLine = result.contains(LadderLineStyle.HORIZONTAL_LINE);

		if (isEmpty) {        //HORIZONTAL_EMPTY를 가지는 경우
			assertFalse(isLine);
		} else {            //HORIZONTAL_LINE을 가지는 경우
			assertTrue(isLine);
		}
	}

	@Test
	@DisplayName("Row 출력 테스트")
	void printRowTest() {
		//given
		int numberOfPlayer = 2;
		int expected = numberOfPlayer;

		//when
		row.makeLine(numberOfPlayer);
		String printRow = row.printRow();
		int result = countPlayer(printRow);

		//then
		assertEquals(expected, result);
	}

	private int countPlayer(String row) {
		int count = 0;
		for (int index = 0; index < row.length(); index++) {
			if ((row.charAt(index) + "").equals(LadderLineStyle.VERTICAL_LINE.getShape())) {
				count++;
			}
		}

		return count;
	}
}