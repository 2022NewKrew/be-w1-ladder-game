package view.output;

import java.util.Map;

public class AnswerPrinter {

    public static void endAnswer(){
        System.out.println("게임을 종료합니다.");
        System.exit(0);
    }

    public static void printAllResult(Map<String, String> peopleToResult) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : peopleToResult.entrySet()){
            sb.append(String.format("%s : %s", entry.getKey(), entry.getValue()));
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void printOneResult(String resultToPerson) {
        System.out.println(resultToPerson + "\n");
    }


}
