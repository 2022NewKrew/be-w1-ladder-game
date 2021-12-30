package view.output;

import domain.ladder.Ladder;
import domain.ladder.LadderWithName;
import domain.ladder.Line;
import type.StuffType;

import java.util.List;

public class LadderPrinterWithName implements LadderPrinter{
    @Override
    public void printLadderShape(Ladder ladder) {
        System.out.println("사다리 결과");

        StringBuilder sb = new StringBuilder();

        // 이름 출력 (업캐스팅)
        printNames(((LadderWithName) ladder).getNames());

        // ladderShape List 를 String 으로 변환
        for(Line line : ladder.getLadderShape()){
            sb.append("  ");
            line.getPoints().stream().forEach(num -> sb.append(StuffType.of(num).getStuff()));
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private void printNames(List<String> names){
        StringBuilder sb = new StringBuilder();
        for(String name : names) {
            int frontSpace = (5 - name.length())/2;
            int backSpace = (5 - name.length())/2 + (5 - name.length())%2 + 1;
            sb.append(String.format(" ".repeat(frontSpace) + "%s" + " ".repeat(backSpace), name));
        }
        System.out.println(sb);
    }
}
