package view;

import java.util.List;
import java.util.stream.Collectors;

public class PrintManager {
    private static final String DELIMITER = " ";

    public PrintManager() {
    }
    public static void printPeople(List<String> namePeople){
        System.out.println(namePeople.stream().map(name->String.format("%-5s",name)).collect(Collectors.joining(DELIMITER)));
    }

    public static void printLadder(String stringLadder) {
        System.out.println(stringLadder);
    }
}
