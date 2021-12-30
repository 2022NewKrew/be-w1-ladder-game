package view.output;

import java.util.Map;

public class AnswerPrinter {

    // 종료 메세지 및 게임 종료를 위해 false를 리턴 (flag)
    public static Boolean endAnswer(){
        System.out.println("게임을 종료합니다.");
        return false;
    }

    // param: Map<이름, 결과>
    public static void printAllResult(Map<String, String> peopleToResult) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : peopleToResult.entrySet()){
            sb.append(String.format("%s : %s", entry.getKey(), entry.getValue()));
            sb.append("\n");
        }
        System.out.println(sb);

    }

    // param: 결과
    public static void printOneResult(String oneResult) {
        System.out.println(oneResult + "\n");
    }


}
