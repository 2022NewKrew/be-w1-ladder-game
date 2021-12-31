package domain;

import repository.Ladder;

import java.util.*;

public class LadderInfoScanner {
    private final StringListScanner nameScanner = new NameScanner();
    private final StringListScanner resultScanner = new ResultScanner();
    private final HeightOfLadderScanner heightScanner = new HeightOfLadderScanner();

    public LadderInfoScanner() { }

    public Ladder getLadder(){
        List<String> names, results;
        do{
            names = nameScanner.getInput();
            results = resultScanner.getInput();
        }while(!validateSize(names, results));

        return new Ladder(heightScanner.getHeightOfLadder(), names, results);
    }

    private boolean validateSize(List<String> names, List<String> results){
        if(names.size() != results.size()){
            System.out.println("참가자의 수와 결과의 개수가 맞지 않습니다.");
            return false;
        }
        return true;
    }
}