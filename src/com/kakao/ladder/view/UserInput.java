package com.kakao.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * author    : brody.moon
 * version   : 1.1
 * 사용자 입력을 위한 클래스입니다.
 * 잘못된 입력은 다시 입력받습니다.
 * 입력 자체가 immutable 할 필요는 없을 것 같아 final 로 선언하지 않았습니다.
 */
public class UserInput {
    /**
     * names        참여 인원 이름
     * ladderHeight 사다리 높이
     * results      유저가 입력한 결과 문자열
     * sc           입력 받을 Scaaner 객체
     */
    private static final Scanner sc = new Scanner(System.in);

    private int ladderHeight;
    private List<String> names;
    private List<String> results;

    /**
     * 생성자 내부에 input 로직을 빼기 위해 생성자를 private 으로 선언
     * getInputInfos 라는 static 메서드를 통해서만 인스턴스 생성 가능
     */
    private UserInput() {
    }

    /**
     * 생성자에서 비지니스 로직을 사용하는 것을 피하기 위해 싱글톤 패턴과 살짝 다르게 작성해 보았습니다.
     *
     * @return UserInput 객체
     */
    public static UserInput getInputInofs() {
        UserInput userinput = new UserInput();
        userinput.inputPlayerInfo();
        return userinput;
    }

    /**
     * 결과 요청 입력이 정상 입력인지 판단하는 로직입니다. ( 춘식이가 입력되면 Scanner 객체를 close 합니다.)
     *
     * @param names 유저가 입력한 결과 문자열
     * @return 정상적인 결과 요청 입력 문자열
     */
    public static String showResult(List<String> names) {
        String whosResult = "";

        while (!(whosResult.equals("춘식이") || whosResult.equals("all") || names.contains(whosResult))) {
            System.out.println("결과를 보고 싶은 사람은?");

            whosResult = sc.nextLine();
        }

        System.out.println();

        if (whosResult.equals("춘식이")) {
            sc.close();
        }

        return whosResult;
    }

    /**
     * 입력 결과를 처리하고 버퍼가 남아있는 문제가 있어서 버퍼를 비우는 메서드를 추가했습니다.
     */
    public static void bufferClear() {
        sc.nextLine();
    }

    /**
     * 입력을 받아 옳바른 요청으로 초기화 진행하는 함수입니다.
     */
    private void inputPlayerInfo() {
        names = iterStringInput("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", sc, this::readStringInitInput, list -> list.size() <= 0);

        results = iterStringInput("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", sc, this::readStringInitInput, list ->
                list.size() != names.size());

        do {
            ladderHeight = readIntInput("최대 사다리 높이는 몇 개인가요?", sc);
        } while (ladderHeight <= 0);
    }

    /**
     * String 입력(이름, 실행결과)를 처리해주는 메서드입니다. 직접 호출하기 보단 iterStringInput 메서드 내부에서 사용합니다.
     *
     * @param printString 출력할 문자열
     * @param sc          Scanner 객체
     * @return 입력 받은 String 입력을 split 해서 반환
     */
    private List<String> readStringInitInput(String printString, Scanner sc) {
        System.out.println(printString);

        String tempUserString = sc.nextLine();

        return Arrays.stream(tempUserString.split(","))
                .filter(tempString -> tempString.length() != 0 && !tempString.equals(","))
                .map(tempString -> tempString.substring(0, Math.min(5, tempString.length())))
//                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * String 입력을 처리하는 코드가 중복되어 중복을 제거하기 위한 메서드
     *
     * @param printString     출력할 문자열
     * @param sc              Scanner 객체
     * @param predicateResult 반복 조건을 설정할 함스형인터페이스
     * @return 옳바른 String 입력을 split 한 결과
     */
    private List<String> iterStringInput(String printString, Scanner sc, BiFunction<String, Scanner, List<String>> readInput, Predicate<List<String>> predicateResult) {
        List<String> tempStringList;

        do {
            tempStringList = readInput.apply(printString, sc);
        } while (predicateResult.test(tempStringList));

        return tempStringList;
    }

    /**
     * 사용자 입력을 받는 함수입니다.
     * 정수 처리를 한 부분으로만해서 iterIntInput 메서드는 구현하지 않음
     *
     * @param printString 출력할 문자열
     * @param sc          입력을 받을 Scanner 객체
     * @return 사용자 지정 정수 ( 잘못된 입력의 경우 0 )
     */
    private int readIntInput(String printString, Scanner sc) {
        System.out.println(printString);

        int tempUserNum = 0;

        try {
            tempUserNum = sc.nextInt();
        } catch (Exception e) {
        }

        if (tempUserNum <= 0) {
            System.out.println("1 이상의 양수 값을 입력해 주세요.");
        }

        return tempUserNum;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getResults() {
        return results;
    }
}
