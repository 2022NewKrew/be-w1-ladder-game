package input;

import dto.LadderInputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CommandLineInputControllerTest {
    InputController inputController = new CommandLineInputController();

    @Test
    @DisplayName("이름이 콤마로 잘 분리되는지 테스트해봅니다.")
    public void separatingTest() {
        // given
        String input = "jeff,andy,keith,binar,champ,clo,hoodi\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        List<String> ans = new ArrayList<>(Arrays.asList("jeff ", "andy ", "keith", "binar", "champ", " clo ", "hoodi"));
        System.setIn(in);

        // when
        LadderInputInfo ladderInputInfo = inputController.inputLadderInfo();
        List<String> participantsNames = ladderInputInfo.getParticipantsNames();
        int numberOfParticipants = ladderInputInfo.getNumberOfParticipants();

        // then
        Assertions.assertThat(participantsNames.size()).isEqualTo(numberOfParticipants);
        Assertions.assertThat(participantsNames).isEqualTo(ans);
    }
}