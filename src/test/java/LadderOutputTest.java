import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderOutputTest {
    String testCase = "eden,rubam,lucas,jin,jindo";
    String testResult = "   eden  rubam lucas  jin  jindo   ";
    PlayerList playerList;
    @BeforeEach
    void setUp(){
        Input<ArrayList<String>> input = new Input(new ArrayList<>(Arrays.asList(testCase.split(","))));
        playerList = new PlayerList(input);
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void test(){
        assertThat(playerList.toString()).isEqualTo(testResult);
    }

}
