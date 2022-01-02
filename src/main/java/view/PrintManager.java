package view;

import DTO.ResultInfo;
import DTO.StartInfo;

import java.util.List;
import java.util.stream.Collectors;

public class PrintManager {
    private static final String DELIMITER = " ";

    public static void printSummary(StartInfo startInfo, ResultInfo resultInfo){
        printPeople(startInfo.getNamePeople());
        printLadder(resultInfo.getStringLadder());
        printResult((startInfo.getResultString()));

    }
    private static void printPeople(List<String> namePeople){
        System.out.println(namePeople
                .stream()
                .map(name->String.format("%-5s",name))
                .collect(Collectors.joining(DELIMITER)));
    }

    private static void printLadder(String stringLadder) {
        System.out.println(stringLadder);
    }
    private static void printResult(List<String> resultString){
        System.out.println(resultString
                .stream()
                .map(result->String.format("%-5s",result))
                .collect(Collectors.joining(DELIMITER)));
    }
}
