package com.kakaocorp.laddergame.ladder.view;

import com.kakaocorp.laddergame.ladder.domain.Line;
import com.kakaocorp.laddergame.ladder.domain.NameLadder;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class LadderView {

    private NameLadder ladder;
    private static final Map<Boolean, String> viewItems = Map.ofEntries(
            entry(false, "     "),
            entry(true, "-----")
    );

    public LadderView() {
    }

    public LadderView(NameLadder ladder) {
        this.ladder = ladder;
    }

    public void print() {
        ladder.getMembers().forEach(member ->
                System.out.print(sliceName(member))
        );
        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            sb.append("  |");
            makeLineTypesString(line.getLineTypes(), sb);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public String sliceName(String member) {
        if (member.length() >= 5) {
            return member.substring(0, 5) + " ";
        }

        return StringUtils.leftPad(member, 5, " ") + " ";
    }

    private void makeLineTypesString(List<Boolean> lineTypes, StringBuilder sb) {
        for (Boolean lineType : lineTypes) {
            sb.append(viewItems.get(lineType));
            sb.append("|");
        }
    }

}
