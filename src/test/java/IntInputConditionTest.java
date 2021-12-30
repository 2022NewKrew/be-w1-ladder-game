import View.Input;
import View.IntInputCondition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class IntInputConditionTest {


    @BeforeEach
    void setUp(){
        System.out.println("test start");
    }

    @AfterEach
    void tearDown(){
        System.out.println("test done");
    }

    @Test
    void underHeightTest(){
        Input<Integer> integerInput = new Input<>(0, new IntInputCondition("",1, ""));
        assertThat(integerInput.isValid()).isEqualTo(false);
    }

    @Test
    void equalHeightTest(){
        Input<Integer> integerInput = new Input<>(1, new IntInputCondition("",1, ""));
        assertThat(integerInput.isValid()).isEqualTo(false);
    }

    @Test
    void overHeightTest(){
        Input<Integer> integerInput = new Input<>(2, new IntInputCondition("",1, ""));
        assertThat(integerInput.isValid()).isEqualTo(true);
    }

}
