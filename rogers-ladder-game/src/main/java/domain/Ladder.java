package domain;

import java.util.List;

public class Ladder {
    private final Lines lines;
    private final People people;
    private final Rewards rewards;

    public Ladder(List<String> peopleNames, List<String> rewardStrings, int ladderHeight) {
        people = new People(peopleNames);
        rewards = new Rewards(rewardStrings, peopleNames.size());
        lines = new Lines(2 * peopleNames.size() - 1, ladderHeight);
    }

    public GameResult getResult(){
        GameResult gameResult = new GameResult();
        for(int personIndex=0; personIndex < people.numberOfPeople(); personIndex++){
            int whichLine = 2 * personIndex;
            int resultLine = lines.followLine(whichLine);
            int rewardIndex = resultLine / 2;

            gameResult.addResult(people.getPerson(personIndex).getName(), rewards.getReward(rewardIndex));
        }

        return gameResult;
    }

    @Override
    public String toString() {
        return people.toString()
                .concat("\n")
                .concat(lines.toString())
                .concat("\n")
                .concat(rewards.toString());
    }
}
