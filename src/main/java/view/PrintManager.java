package view;

import DTO.ResultInfo;
import DTO.StartInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintManager {
    private static final String DELIMITER = " ";

    public static void printSummary(StartInfo startInfo, ResultInfo resultInfo){
        printPeople(startInfo.getNamePeople());
        printLadder(resultInfo.getStringLadder());
        printResult((startInfo.getResultString()));
    }
    private static HashMap<String, String> makeResultMap(StartInfo startInfo, ResultInfo resultInfo){
        HashMap<String, String> resultMap = new HashMap<>();
        IntStream
                .range(0,startInfo.getNamePeople().size())
                .boxed()
                .forEach(i -> resultMap.put(startInfo.getNamePeople().get(i),
                        startInfo.getResultString().get(resultInfo.getResultOrder().indexOf(i))));
        return resultMap;
    }
    public static void checkResult(StartInfo startInfo, ResultInfo resultInfo){
        HashMap<String, String> resultMap = makeResultMap(startInfo, resultInfo);

        String key = InputManager.makePrintName();
        while(!key.equals("춘식이")){
            if(key.equals("all")){
                String allResult = resultMap
                        .keySet()
                        .stream()
                        .map(forkey -> forkey + " : " + resultMap.get(forkey))
                        .collect(Collectors.joining("\n"));
                System.out.println(allResult);
                key = InputManager.makePrintName();
                continue;
            }
            System.out.println("실행결과\n"+resultMap.get(key));
            key = InputManager.makePrintName();
        }
        System.out.println("게임을 종료합니다.");
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
