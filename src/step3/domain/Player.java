package step3.domain;

import java.util.*;

public class Player {
    private int countOfPeople;
    private List<String> names;
    private HashMap<String, Integer> nameMap;

    public Player(String people) {
        this.names = Arrays.asList(people.split(","));
        this.countOfPeople = names.size();
        nameMap = new HashMap<String, Integer>();
        for(int i=0; i<countOfPeople;i++){
            nameMap.put(names.get(i),i);
        }
    }

    public List<String> getNameOfPeople() { return this.names; }

    public int getCountOfPeople() { return this.countOfPeople; }

    public int getNameIndex(String name) {
        if(nameMap.containsKey(name))
            return nameMap.get(name);
        return -1;
    }

}
