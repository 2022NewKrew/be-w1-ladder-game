package factory;

import domain.Ladder;

import java.util.List;

public class LadderFactory {
    private static Ladder instance = null;

    public static Ladder getInstance(List<String> peopleNames , int ladderHeight){
        if(instance == null){
            instance = new Ladder(peopleNames, ladderHeight);
        }

        return instance;
    }
}
