package domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFrameLineTest {


    public static final int NUMBER_OF_FRAME = 5;

    @Test
    void constructorTest(){
        LadderFrameLine testLadderFrameLine = new LadderFrameLine(NUMBER_OF_FRAME);
        assertThat(testLadderFrameLine.getFrames().size()).isEqualTo(NUMBER_OF_FRAME);
        assertThat(checkFrames(testLadderFrameLine.getFrames())).isTrue();
    }

    private boolean checkFrames(List<LadderFrame> frames){
        LadderFrame previousFrame = null;
        for(LadderFrame frame : frames){
            if(frame == LadderFrame.BRIDGE && frame == previousFrame){
                return false;
            }
            previousFrame = frame;
        }
        return true;
    }

}
