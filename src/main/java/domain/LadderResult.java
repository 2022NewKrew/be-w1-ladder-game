package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Ladder ladder;
    private final Person person;
    private final Results result;

    public LadderResult(Ladder ladder, Person person, Results result) {
        this.ladder = ladder;
        this.person = person;
        this.result = result;
    }

    public String findResult(String name){
        int index = person.getPerson().indexOf(name);
        if(index < 0){
            return "Not Found";
        }
        int resultIndex = ladder.ladderResult(index);

        return result.getResult().get(resultIndex);
    }

    public Map<String, String> findAllResult(){
        Map<String, String> resultMap = new HashMap<>();

        for (String name : person.getPerson()) {
            resultMap.put(name, findResult(name));
        }

        return resultMap;
    }

    public List<Line> getLadder() {
        return ladder.getLadder();
    }

    public List<String> getPerson() {
        return person.getPerson();
    }

    public List<String> getResult() {
        return result.getResult();
    }
}
