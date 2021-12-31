package ladder.view;

import ladder.domain.LadderConfig;
import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class IO {
    private static final String qPeopleNames = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String qOutputs = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String qMaxHeight = "최대 사다리 높이는 몇 개인가요?";
    private static final String qShowResultsOf = "결과를 보고 싶은 사람은?";
    private static Scanner scanner = new Scanner(System.in);

    public IO() {
    }

    public LadderConfig getInput(){

        String[] peopleNames = this.setPeopleNames(scanner);
        String[] outputs = this.setOutputs(scanner);
        int nPeople = this.setNumPeople(peopleNames);
        int maxHeight = this.setMaxHeight(scanner);

        LadderConfig ladderConfig = new LadderConfig(nPeople, maxHeight, peopleNames, outputs);
        return ladderConfig;
    }

    private String[] setOutputs(Scanner scanner) {
        System.out.println(qOutputs);
        String strPeopleNames = scanner.next();
        String[] outputs = strPeopleNames.split(",");
        return outputs;
    }

    public String[] setPeopleNames(Scanner scanner) {
        System.out.println(qPeopleNames);
        String strPeopleNames = scanner.next();
        String[] peopleNames= strPeopleNames.split(",");

        return peopleNames;
    }
    public int setNumPeople(String[] peopleNames) {
        int nPeople = peopleNames.length;
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

    public String getResultsUser(){
        System.out.println(qShowResultsOf);
        String resultUser = scanner.next();
        return resultUser;

    }

    public static void printResultEach(String output){
        System.out.println("실행결과?\n"+output);
    }




}