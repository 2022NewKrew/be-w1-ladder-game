package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameRepository {
    private List<Name> nameList = new ArrayList<>();

    public NameRepository(List<String> names) {
        names.stream().forEach(name ->
                nameList.add(new Name(name)));
    }

    public List<Name> getNameList() {
        return nameList;
    }

    public int getLength() {
        return nameList.size();
    }

    public void validationCheck() {
        if (nameList.size() <= 1) {
            throw new IllegalArgumentException("사다리 게임을 진행하기 위해 최소 2명이 필요합니다.");
        }
        for (Name name : nameList) {
            name.nameValid();
        }
    }

    public void validationCheck(int personNum){
        if(nameList.size() != personNum){
            throw new IllegalArgumentException("사람 수와 결과 수가 다릅니다");
        }
    }


    public void swap(int idx) {
        Collections.swap(nameList, idx, idx + 1);
    }

    public int matchName(String s){
        for(int i =0; i<nameList.size(); i++){
            if(nameList.get(i).getName().equals(s)){
                return i;
            }
        }
        return -1;
    }

}
