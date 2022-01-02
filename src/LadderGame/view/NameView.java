package LadderGame.view;

import LadderGame.domain.UserList;
import LadderGame.domain.User;

public class NameView {
    private static final int MAX_NAME_SIZE = 5;
    private static final int SPACE = 1;

    private final UserList names;

    NameView(UserList names) {
        this.names = names;
    }

    public String showNames() {
        StringBuilder namesOutput = new StringBuilder();
        for (User user : this.names.getUserList()) {
            String name = user.getName();
            int padding = ((MAX_NAME_SIZE - name.length()) / 2) + SPACE;
            int oddPadding = name.length()%2;
            namesOutput.append(" ".repeat(padding)).append(name).append(" ".repeat(padding-oddPadding));
        }
        namesOutput.append("\n");
        return namesOutput.toString();
    }

}
