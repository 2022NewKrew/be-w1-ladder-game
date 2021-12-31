package ladder.view;

import ladder.domain.LadderConfig;
import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class IO {
    private static final String qPeopleNames = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String qNumPeople = "참여할 사람은 몇 명인가요?";
    private static final String qMaxHeight = "최대 사다리 높이는 몇 개인가요?";




    public IO() {
    }

    public LadderConfig getInput(){
        Scanner scanner = new Scanner(System.in);

        String[] peopleNames = this.setPeopleNames(scanner);
        int nPeople = this.setNumPeople(scanner);
        int maxHeight = this.setMaxHeight(scanner);

        LadderConfig ladderConfig = new LadderConfig(nPeople, maxHeight, peopleNames);
        return ladderConfig;
    }
    public String[] setPeopleNames(Scanner scanner) {
        System.out.println(qPeopleNames);
        String strPeopleNames = scanner.next();
        String[] peopleNames= strPeopleNames.split(",");

        return peopleNames;
    }
    public int setNumPeople(Scanner scanner) {
        System.out.println(qNumPeople);
        int nPeople = scanner.nextInt();
        return nPeople;
    }

    public int setMaxHeight(Scanner scanner) {
        System.out.println(qMaxHeight);
        int maxHeight = scanner.nextInt();
        return maxHeight;
    }

    public void printLadder(String ladderStr){
        System.out.println(ladderStr);
    }




}