package view;

import domain.GameResult;
import dto.OutputDto;

import java.util.Scanner;

public class OutputView {
    private static final String END_PRINT_NAME = "춘식이";

    public static void output(OutputDto outputDto, Scanner scanner){
        System.out.println(outputDto.getLadderBoard());
        showResultLoop(scanner, outputDto.getGameResult());
        System.out.println("게임을 종료합니다.");
    }

    private static void showResultLoop(Scanner scanner, GameResult gameResult){
        String command = null;
        while(!(command != null && command.equals(END_PRINT_NAME))) {
            showResult(command, gameResult);
            System.out.println("결과를 보고 싶은 사람은?");
            command = scanner.next();
        }
    }

    private static void showResult(String command, GameResult gameResult){
        if(command == null){
            return;
        }

        if(command.equals("all")){
            System.out.println(gameResult.getResultAll());
            return;
        }

        System.out.println(gameResult.getResult(command));
    }
}
