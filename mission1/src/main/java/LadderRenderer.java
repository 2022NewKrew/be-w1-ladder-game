import java.util.ArrayList;
import java.util.Collections;

public class LadderRenderer {
    static void render(LadderInputManager ladderInputManager, LadderMaker ladderMaker) {
        renderPlayers(ladderInputManager.getPlayerList());
        renderLadder(ladderMaker.getLadder(), ladderMaker.getOffset(), ladderMaker.getNameLen());
    }

    static void renderPlayers(ArrayList<String> playerList) {
        int i;
        for (i=0; i<playerList.size()-1; i++) {
            System.out.printf("%-5s ", playerList.get(i));
        }
        System.out.printf("%5s ", playerList.get(i));
        System.out.println();
    }

    static void renderLadder(ArrayList<Line> ladder, int offset, int nameLen) {
        StringBuilder ladderString = new StringBuilder();
        for (Line line : ladder) {
            ladderString.append(renderLine(line.getPoints(), offset, nameLen));
        }
        System.out.println(ladderString);
    }

    static StringBuilder renderLine(ArrayList<Boolean> points, int offset, int nameLen) {
        StringBuilder lineString = new StringBuilder();

        //offset 만큼 공백을 더함
        lineString.append(String.join("", Collections.nCopies(offset, " ")));

        //nameLen 만큼 공백이나 가로선을 더함
        for (boolean point : points) {
            lineString.append("|");
            String row = point ? "-" : " ";
            lineString.append(String.join("", Collections.nCopies(nameLen, row)));
        }
        lineString.append("|\n");

        return lineString;
    }
}
