package factory;

import ladder.Ladder;

public class LadderFactory {
    public Ladder getInstance(int numberOfPeople, int ladderHeight){
        return new Ladder(numberOfPeople, ladderHeight);
    }
}
