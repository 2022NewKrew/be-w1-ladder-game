package view.output;

import domain.ladder.Ladder;
import domain.ladder.Line;
import type.StuffType;

public class LadderPrinterImpl implements LadderPrinter{

    @Override
    public void printLadderShape(Ladder ladder) {
        // ladderShape List 를 String 으로 변환
        System.out.println("사다리 결과");

        StringBuilder sb = new StringBuilder();

        for(Line line : ladder.getLadderShape()){
            line.getPoints().stream().forEach(num -> sb.append(StuffType.of(num).getStuff()));
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
