package factory;

import ladder.Ladder;

public class LadderFactory {
    public Ladder getInstance(int people, int height){
        return new Ladder(people, height);
    }
}
