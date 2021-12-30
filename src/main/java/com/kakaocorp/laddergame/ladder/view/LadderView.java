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

    public void ladderPrint() {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            sb.append("  |");
            makeLineTypesString(line.getLineTypes(), sb);
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }

    public String sliceName(String member) {
        if (member.length() >= 5) {
            return member.substring(0, 5) + " ";
        }

        return StringUtils.leftPad(member, 5, " ") + " ";
    }

    public String sliceResult(String result) {
        if (result.length() >= 5) {
            return result.substring(0, 5) + " ";
        }
        String leftPaddedResult = StringUtils.leftPad(result, (5 - result.length()) / 2, " ");
        return StringUtils.rightPad(leftPaddedResult, 5, " ") + " ";
    }

    private void makeLineTypesString(List<Boolean> lineTypes, StringBuilder sb) {
        for (Boolean lineType : lineTypes) {
            sb.append(viewItems.get(lineType));
            sb.append("|");
        }
    }

    public void memberPrint() {
        ladder.getMembers().forEach(member ->
                System.out.print(sliceName(member))
        );
        System.out.println();
    }

    public void resultPrint() {
        ladder.getResults().forEach(result ->
                System.out.print(sliceResult(result))
        );
        System.out.println();
    }
}
