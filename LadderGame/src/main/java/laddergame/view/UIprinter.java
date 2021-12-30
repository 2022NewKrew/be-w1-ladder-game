package laddergame.view;

import java.util.List;

public class UIprinter {
    // 사다리에 참가자들의 이름을 라벨링하는 메소드
    public void printLabel(List<String> playerNames, int maxPlayerNum){
        StringEditor se = new StringEditor();
        System.out.print("   ");
        for(String name : playerNames){
            System.out.print(se.paddingName(name, maxPlayerNum));
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    //----------------------------------------------------
    // 2. 사다리의 한 행을 출력하기 위한 메소드들

    // 사다리의 특정 위치에서의 선의 유무에 따른 선 출력
    private void printLine(List<Boolean> lines, int col, int lineLength){
        String lineStr = "-";
        String spaceStr = " ";
        if(lines.get(col)){
            System.out.print(lineStr.repeat(lineLength));
            return;
        }
        System.out.print(spaceStr.repeat(lineLength));
    }

    // 사다리의 한 행을 출력하는 메소드
    public void printRow(List<Boolean> lines, int colNum, int lineLength){
        String spaceStr = " ";
        System.out.print(spaceStr.repeat(lineLength));
        for(int col=0; col<colNum; col++){
            System.out.print("|");
            this.printLine(lines, col, lineLength);
        }
        System.out.print("|\n");
    }
    //----------------------------------------------------
}
