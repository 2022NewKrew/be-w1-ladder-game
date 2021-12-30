package laddergame.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class LadderComponent {

    private final Boolean hasRightHorizon;
    private final Boolean hasLeftHorizon;

    public LadderComponent(Boolean isEndVertical, Boolean hasLeftHorizon) {
        this.hasRightHorizon = makeRightHorizon(isEndVertical, hasLeftHorizon);
        this.hasLeftHorizon = hasLeftHorizon;
    }

    public Boolean hasRightHorizon() {
        return hasRightHorizon;
    }

    public Boolean hasLeftHorizon() {
        return hasLeftHorizon;
    }

    private Boolean makeRandomHorizon() {
        try {
            Random rand = SecureRandom.getInstanceStrong();
            return rand.nextBoolean();
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    private Boolean makeRightHorizon(Boolean isEndVertical, Boolean hasLeftVertical) {
        if (isEndVertical) {
            return false;
        }

        if (hasLeftVertical) {
            return false;
        }

        return makeRandomHorizon();
    }
}
