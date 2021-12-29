package view;

import domain.Ladder;

public class LadderRenderer {
    private Ladder ladder;

    public LadderRenderer(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printAll() {
        System.out.println(printNames());
        for(int i = 0 ; i < ladder.getHeightOfLadder() ; i++) {
            System.out.println(ladder.getLine(i).printLine(ladder.getCountOfPerson()));
        }
    }

    public String printNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < ladder.getCountOfPerson() ; i++) {
            stringBuilder.append(printName(ladder.getPeople().get(i)));
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
