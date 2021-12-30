package LadderGame.view;

import LadderGame.domain.Name;

public class NameView {
    private static final int MAX_NAME_SIZE = 5;
    private static final int SPACE = 1;

    private final Name names;

    NameView(Name names) {
        this.names = names;
    }

    @Override
    public String toString() {
        StringBuilder namesOutput = new StringBuilder();
        for (String name : this.names.getNameList()) {
            int padding = ((MAX_NAME_SIZE - name.length()) / 2) + SPACE;
            int oddPadding = name.length()%2;
            namesOutput.append(" ".repeat(padding)).append(name).append(" ".repeat(padding-oddPadding));
        }
        namesOutput.append("\n");
        return namesOutput.toString();
    }

}
