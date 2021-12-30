package view;

import java.util.List;
import java.util.stream.Collectors;

public class NameView {

    private final List<String> nameList;

    private NameView(List<String> nameList) {
        this.nameList = nameList;
    }

    public static NameView create(List<String> nameList) {
        return new NameView(nameList);
    }

    public String getNameView() {
        return String.join(" ", makeFiveWords());
    }

    public void printNameList() {
        System.out.println(getNameView());
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
