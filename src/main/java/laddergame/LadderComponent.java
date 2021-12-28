package laddergame;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class LadderComponent {

    private final Boolean hasRightVertical;
    private final Boolean hasLeftVertical;

    public LadderComponent(Boolean isEnd, Boolean hasLeftVertical) {
        this.hasRightVertical = !isEnd && !hasLeftVertical && makeRandomVertical();
        this.hasLeftVertical = hasLeftVertical;
    }

    public Boolean hasRightVertical() {
        return hasRightVertical;
    }

    public Boolean hasLeftVertical() {
        return hasLeftVertical;
    }

    private Boolean makeRandomVertical() {
        try {
            Random rand = SecureRandom.getInstanceStrong();
            return rand.nextBoolean();
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
