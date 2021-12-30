package domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String BANNER = "실행 결과\n";

    private final Map<String, Reward> resultMap;

    public GameResult(){
        this.resultMap = new HashMap<>();
    }

    public void addResult(String personName, Reward reward){
        this.resultMap.put(personName, reward);
    }

    public String getResultAll(){
        return resultMap.entrySet().stream()
                .map(entry -> entry.getKey().concat(" : ").concat(entry.getValue().toString()).concat("\n"))
                .reduce("", String::concat);
    }

    public String getResult(String name){
        if(!resultMap.containsKey(name)){
            return BANNER.concat("해당 이름을 가진 사람 없음.");
        }

        Reward reward = resultMap.get(name);
        return BANNER.concat(reward.toString());
    }

}
