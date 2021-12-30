package domain;

import java.util.ArrayList;
import java.util.List;

public class NameRepository {
    private final List<Name> nameList = new ArrayList<>();

    public NameRepository(List<String> names) {
        names.stream().forEach(name->
                nameList.add(new Name(name)));
    }

    public List<Name> getNameList() {
        return nameList;
    }

    public int getLength(){
        return nameList.size();
    }

    public void validationCheck(){
        if (nameList.size() <= 1) {
            throw new IllegalArgumentException("사다리 게임을 진행하기 위해 최소 2명이 필요합니다.");
        }
        for(Name name: nameList){
            name.nameValid();
        }
    }
}
