package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Ladder {
    private int countOfPerson;
    private int heightOfLadder;

    private List<String> people = new ArrayList<String>();
    private ArrayList<Line> ladder = new ArrayList<Line>();

    public Ladder() {
        inputLadder();
        for(int i = 0 ; i < heightOfLadder ; i++) {
            Line line = new Line(countOfPerson);
            ladder.add(line);
        }
    }

    private void inputLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        people = Arrays.asList(scanner.nextLine().split(","));
        countOfPerson = people.size();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = scanner.nextInt();
    }

    public void printLadder() {
        System.out.println(printNames());
        for(int i = 0 ; i < heightOfLadder ; i++) {
            System.out.println(ladder.get(i).printLine(countOfPerson));
        }
    }

    public String printNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < countOfPerson ; i++) {
            stringBuilder.append(printName(people.get(i)));
        }
        return stringBuilder.toString();
    }

    public String printName(String name) {
        int nameLength = name.length();
        if (nameLength >= 5) {
            return name.substring(0,5) + " ";
        }
        return " ".repeat((6-nameLength)/2) + name + " ".repeat((7-nameLength)/2);
    }
}