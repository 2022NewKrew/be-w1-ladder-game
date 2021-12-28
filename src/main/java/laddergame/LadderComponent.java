package laddergame;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class LadderComponent {

    private final Boolean hasRightVertical;
    private final Boolean hasLeftVertical;

    public LadderComponent(Boolean isEnd, Boolean hasLeftVertical) {
        this.hasRightVertical = makeRightVertical(isEnd, hasLeftVertical);
        this.hasLeftVertical = hasLeftVertical;
    }

    public Boolean hasRightVertical() {
        return hasRightVertical;
    }

    private Boolean makeRandomVertical() {
        try {
            Random rand = SecureRandom.getInstanceStrong();
            return rand.nextBoolean();
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    private Boolean makeRightVertical(Boolean isEnd, Boolean hasLeftVertical) {
        if (isEnd) {
            return false;
        }

        if (hasLeftVertical) {
            return false;
        }

        return makeRandomVertical();
    }
}
