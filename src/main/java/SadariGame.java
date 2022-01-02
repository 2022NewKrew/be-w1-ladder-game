import domain.sadari.result.SadariResults;
import domain.sadari.Sadari;
import domain.sadari.SadariMap;
import domain.user.Users;
import domain.user.dto.UserDto;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SadariGame {

    private static final Scanner sc = new Scanner(System.in);
    private static Sadari sadari;

    public static void main(String[] args) {
        sadari = inputSadariGameSetting();
        sadari.startGame();
        while (!"춘식이".equals(executeCommand())) {}
        System.out.println("게임을 종료합니다.");
    }

    private static Sadari inputSadariGameSetting() {
        Users users = inputUsers();
        SadariResults sadariResults = inputSadariResults();
        int numberOfLadder = inputNumberOfLadder();

        SadariMap sadariMap = new SadariMap(users.getNumberOfUser(), numberOfLadder);
        SadariMaker sadariMaker = new SadariMakerImpl(sadariMap);
        SadariPrinter sadariPrinter = new SadariPrinterImpl(users, sadariMap, sadariResults);
        SadariFinder sadariFinder = new SadariFinderImpl(users, sadariMap, sadariResults);

        return new Sadari(sadariMaker, sadariPrinter, sadariFinder);
    }

    private static Users inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<UserDto> userDtos = createUserDtos(sc.nextLine().split(","));
        return new Users(userDtos);
    }

    private static List<UserDto> createUserDtos(String[] splitNames) {
        List<UserDto> userDtos = new ArrayList<>();
        for (int i = 0; i < splitNames.length; i++) {
            userDtos.add(new UserDto(splitNames[i], i + 1));
        }
        return userDtos;
    }

    private static SadariResults inputSadariResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new SadariResults(sc.nextLine().split(","));
    }

    private static int inputNumberOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return Integer.parseInt(sc.nextLine());
    }

    private static String inputCommand() {
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }

    private static String executeCommand() {
        String command = inputCommand();
        if ("all".equals(command)) {
            sadari.playAll();
            return "all";
        }

        if (!"춘식이".equals(command)) {
            sadari.play(command);
            return command;
        }

        return command;
    }
}
