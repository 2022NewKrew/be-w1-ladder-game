package step3.domain;

import java.util.*;

public class Player {
    private int countOfPeople;
    private List<String> names;
    public Player(String people) {
        this.names = Arrays.asList(people.split(","));
        this.countOfPeople = names.size();
    }

    public List<String> getNameOfPeople(){
        return this.names;
    }

    public int getCountOfPeople(){
        return this.countOfPeople;
    }
}
