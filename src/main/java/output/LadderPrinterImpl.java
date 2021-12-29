package output;

import java.util.List;

public class LadderPrinterImpl implements LadderPrinter{

    @Override
    public void printLadderShape(List<List<String>> ladderShape) {
        // ladderShape List 를 String 으로 변환
        StringBuilder sb = new StringBuilder();
        for(List<String> innerArray : ladderShape){
            innerArray.stream().forEach(st -> sb.append(st));
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
