package view.output;

import domain.ladder.Ladder;
import domain.ladder.LadderWithName;
import domain.ladder.LadderWithResult;
import domain.ladder.Line;
import type.StuffType;

import java.util.List;

public class LadderPrinterWithResult implements LadderPrinter{
    @Override
    public void printLadderShape(Ladder ladder) {
        System.out.println("사다리 결과");

        StringBuilder sb = new StringBuilder();

        // 이름 출력 (다운캐스팅)
        printContainer(((LadderWithName) ladder).getNames());

        // ladderShape List 를 String 으로 변환
        for(Line line : ladder.getLadderShape()){
            sb.append("  ");
            line.getPoints().stream().forEach(num -> sb.append(StuffType.of(num).getStuff()));
            sb.append('\n');
        }
        System.out.print(sb);

        // 결과 출력 (다운캐스팅)
        printContainer(((LadderWithResult) ladder).getResults());
    }

    // 이름과 결과 출력 함수
    private void printContainer(List<String> container){
        StringBuilder sb = new StringBuilder();
        for(String name : container) {
            int frontSpace = (5 - name.length())/2;
            int backSpace = (5 - name.length())/2 + (5 - name.length())%2 + 1;
            sb.append(String.format(" ".repeat(frontSpace) + "%s" + " ".repeat(backSpace), name));
        }

        System.out.println(sb);
    }
}
