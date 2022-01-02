package LadderGame.view;

import LadderGame.domain.*;

public class LineView {

    private final Line lines;

    LineView(Line lines){
        this.lines = lines;
    }

    @Override
    public String toString() {
        int padding = UserList.firstNameLength / 2 + 1;
        return " ".repeat(padding) + String.join("", lines.getPoints()) + "\n";
    }
}
