package main;

import main.domain.vo.LadderInput;
import main.view.LadderGame;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LadderInput input = getGameInput();
        new LadderGame(input).start();
    }

    private static LadderInput getGameInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.) (최대 5글자)");
        String[] playerNames = sc.nextLine().split("\\s*[,]\\s*");

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = sc.nextLine().split("\\s*[,]\\s*");

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        return new LadderInput(playerNames, results, height);
    }
}