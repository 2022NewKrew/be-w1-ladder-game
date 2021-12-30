package view;

import java.util.List;
import java.util.stream.Collectors;

public class StringView {

    private final List<String> nameList;

    private StringView(List<String> nameList) {
        this.nameList = nameList;
    }

    public static StringView create(List<String> nameList) {
        return new StringView(nameList);
    }

    public String getStringView() {
        return String.join(" ", makeFiveWords());
    }

    public void printStrings() {
        System.out.println(getStringView());
    }

    private List<String> makeFiveWords() {
        return nameList.stream()
                .map(this::makeFiveWord)
                .collect(Collectors.toList());
    }

    private String makeFiveWord(String name) {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" ".repeat(Math.max(0, 5 - sb.length())));
        return sb.toString();
    }
}
