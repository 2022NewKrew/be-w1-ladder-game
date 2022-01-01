package ladder.domain;

import java.util.Random;

public class RandomBooleanGenerate {
    private final Random random = new Random();
    private boolean isPrev = false;

    public boolean checkCanDraw() {
        if(isPrev){
           return isPrev = false;
        }
        return isPrev = random.nextBoolean();
    }
}
