package laddergame;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class LadderComponent {

    private final Boolean hasVertical;

    public LadderComponent(Boolean isEnd) {
        this.hasVertical = !isEnd && makeRandomVertical();
    }

    public Boolean hasVertical() {
        return hasVertical;
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
