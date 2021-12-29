import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class IntInputConditionTest {

    static Input<Integer> integerInput;

    @BeforeEach
    void setUp(){
        integerInput = new Input<>();
        System.out.println("test start");
    }

    @AfterEach
    void tearDown(){
        System.out.println("test done");
    }

    @Test
    void underHeightTest(){
        integerInput.setValue(0);
        integerInput.setInputCondition(new IntInputCondition("",1, ""));
        assertThat(integerInput.isValid()).isEqualTo(false);
    }

    @Test
    void equalHeightTest(){
        integerInput.setValue(0);
        integerInput.setInputCondition(new IntInputCondition("", 1, ""));
        assertThat(integerInput.isValid()).isEqualTo(false);
    }

    @Test
    void overHeightTest(){
        integerInput.setValue(2);
        integerInput.setInputCondition(new IntInputCondition("", 1, ""));
        assertThat(integerInput.isValid()).isEqualTo(true);
    }

}
