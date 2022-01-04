package Ladder.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NameLine {
    private final List<String> names;

    private static final int NAME_LEN = 5;
    private static final String BLANK = " ";

    public NameLine(List<String> nameLine) {
        names = nameLine;
    }

    public List<String> getPrintLine() {
        List<String> printList = new ArrayList<>();

        for (String name : names) {
            String alignedName = centAlign(name);
            printList.add(alignedName);
            printList.add(BLANK);
        }

        return printList;
    }

    public static String centAlign(@NotNull String str) {
        if (str.length() >= NAME_LEN) {
            return str.substring(0, NAME_LEN);
        }

        int preBlankLen = (NAME_LEN - str.length()) / 2;
        int postBlankLen = (NAME_LEN - str.length() + 1) / 2;
        StringBuilder sb = new StringBuilder();

        sb.append(" ".repeat(preBlankLen));
        sb.append(str);
        sb.append(" ".repeat(postBlankLen));

        return sb.toString();
    }
}