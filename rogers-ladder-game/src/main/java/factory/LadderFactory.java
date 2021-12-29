package factory;

import ladder.Ladder;

public class LadderFactory {
    private static Ladder instance = null;

    public static Ladder getInstance(int numberOfPeople, int ladderHeight){
        if(instance == null){
            instance = new Ladder(numberOfPeople, ladderHeight);
        }

        return instance;
    }
}
