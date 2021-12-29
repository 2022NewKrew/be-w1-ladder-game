package kakao2022.david.sadari.step3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {
    public static Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> peopleList = new ArrayList<>();
    private final int countOfPerson;
    private final int ladderHeight;
    private final ArrayList<Line> ladderBoard = new ArrayList<>();

    public Ladder(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] people = scanner.next().split(",");
        for (String person : people){
            addPerson(person);
        }
        countOfPerson = peopleList.size();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
    }

    private void addPerson(String person){
        try {
            checkNameLength(person);
            peopleList.add(person);
        }catch (NameLengthException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private void checkNameLength(String person) throws NameLengthException{
        if (person.length() > 5){
            throw new NameLengthException("이름은 최대 5글자 까지 부여할 수 있습니다.");
        }
    }

    private void makeLine(){
        for (int i = 0; i < ladderHeight; i++){
            Line line = new Line(countOfPerson);
            ladderBoard.add(line);
        }
    }

    public void startGame(){
        makeLine();
        LadderUI.printPeopleList(peopleList);
        LadderUI.printLadder(ladderBoard);
    }
}
