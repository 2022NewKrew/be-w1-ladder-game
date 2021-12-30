import ladder.LadderGame;
import ladder.dto.InputDTO;
import ladder.exception.CountOfPeopleException;
import ladder.exception.HeightOfLadderException;
import ladder.exception.NameLengthException;
import ladder.validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    LadderGame ladderGame;

    @Test
    @DisplayName("이름 입력이 정확하게 되어지는지 확인")
    public void inputNameEqualTest() {
        //given
        String[] names = {"m", "mo", "moo", "mooo", "moook"};
        int heightOfLadder = 5;
        //when
        ladderGame = new LadderGame(new InputDTO(names, heightOfLadder));
        //then
        Assertions.assertArrayEquals(ladderGame.getNamesOfPeople(), names);
    }

    @Test
    @DisplayName("입력한 이름의 최대 길이가 넘어갈 때")
    public void exceedPeopleNameLengthTest() {
        //given
        String[] names = {"moook", "abcdefg", "asadasa", "abasdfas"};
        //when
        NameLengthException exception = Assertions.assertThrows(NameLengthException.class,
                () -> Validation.nameValidation(names));
        //then
        Assertions.assertEquals("사람 이름은 최대 5글자로 입력해주세요", exception.getMessage());
    }

    @Test
    @DisplayName("사다리게임의 최소 인원이 부족할 때")
    public void lackCountOfPeopleTest() {
        //given
        String[] names = {""};
        //when
        CountOfPeopleException exception = Assertions.assertThrows(CountOfPeopleException.class,
                () -> Validation.nameValidation(names));
        //then
        Assertions.assertEquals("사람을 2명이상 입력해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("사다리의 높이가 0 이하일 때")
    public void lackLadderHeightTest() {
        //given
        int height = -1;
        //when
        HeightOfLadderException exception = Assertions.assertThrows(HeightOfLadderException.class,
                () -> Validation.heightValidation(height));
        //then
        Assertions.assertEquals("사다리 높이는 0 이상을 입력해주세요.", exception.getMessage());
    }

}
