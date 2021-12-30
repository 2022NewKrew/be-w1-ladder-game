package com.kakao.ladder.model;

import com.kakao.ladder.controller.ConstStringSpace;
import com.kakao.ladder.view.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * author    : brody.moon
 * version   : 1.2
 * 사다리 클래스입니다.
 * 모든 멤버 변수가 final 이라 immutable class 입니다.
 * 사다리 객체가 생성될 때 결과도 즉시 생성됩니다.
 */
public class Ladder {
    /**
     * memberNum    참여 인원 수
     * ladderHeight 사다리 높이
     * ladderStatus 사다리 모양
     * names        사용자 이름
     * resultNames  결과 문자열
     * result       사다리 결과
     * random       랜덤 객체
     */
    private static final Random random = new Random();

    private final int memberNum;
    private final int ladderHeight;
    private final List<List<State>> ladderStatus;
    private final List<String> names;
    private final List<String> resultNames;
    private final Map<String, String> result;

    /**
     * 사다리 연결 부분이 있는지 없는지를 enum 으로 만들었습니다.
     * EXIST    연결 부분 존재
     * NONEXIST 연결 부분 없음
     */
    private enum State {
        EXIST, NONEXIST
    }

    /**
     * 생성자에서 초기화 후 클래스 변동 없음
     *
     * @param input 사용자 입력
     */
    public Ladder(UserInput input) {
        this.memberNum = input.getNames().size() - 1;
        this.ladderHeight = input.getLadderHeight();
        this.names = input.getNames();
        this.resultNames = input.getResults();
        this.ladderStatus = initLadderStatus();
        this.result = resultCalc();
    }

    /**
     * 사다리 모양 결정 메서드입니다.
     *
     * @return immutable List 객체 반환 ( 2D List)
     */
    private List<List<State>> initLadderStatus() {
        List<List<State>> temp2DList = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            temp2DList.add(initLadderColStatus());
        }

        return Collections.unmodifiableList(temp2DList);
    }

    /**
     * 사다리 상태 한 행을 초기화 해주는 함수입니다.
     * 연속적인 연결은 제거합니다.
     *
     * @return immutable List 객체를 반환 ( 1D List)
     */
    private List<State> initLadderColStatus() {
        List<State> tempList = new ArrayList<>();

        tempList.add(0, random.nextBoolean() ? State.EXIST : State.NONEXIST);
        for (int i = 1; i < memberNum; i++) {
            tempList.add(i, tempList.get(i - 1) == State.EXIST ?
                    State.NONEXIST : random.nextBoolean() ?
                    State.EXIST : State.NONEXIST);
        }

        return Collections.unmodifiableList(tempList);
    }

    /**
     * 사다리 모양을 보고 결과를 도출하는 메서드입니다.
     *
     * @return 사다리 게임 결과를 가진 immutableMap 반환
     */
    private Map<String, String> resultCalc() {
        HashMap<String, String> tempHashMap = new HashMap<>();

        List<String> tempList = names.stream().collect(Collectors.toList());
        for (int i = 0; i < ladderHeight; i++) {
            resultCalcPerRow(tempList, i);
        }

        for (int i = 0; i < names.size(); i++) {
            tempHashMap.put(tempList.get(i), resultNames.get(i));
        }

        return Collections.unmodifiableMap(tempHashMap);
    }

    /**
     * resultCalc 클래스 depth 를 줄이기 위한 메서드이니다.
     *
     * @param tempList 사용자 이름을 담고 있는 임시 List
     * @param row      사다리의 행번호
     */
    private void resultCalcPerRow(List<String> tempList, int row) {
        for (int i = 0; i < memberNum; i++) {
            isSwapCondition(tempList, row, i);
        }
    }

    /**
     * depth를 줄이기 위해 사용한 함수
     * 사다리가 연결되어 있으면 연결된 부분에서 서로 위치를 바꿔줍니다.
     *
     * @param tempList 사용자 이름을 담고 있는 임시 List
     * @param row      사다리의 행번호
     * @param col      사디리의 열번호
     *                 호
     */
    private void isSwapCondition(List<String> tempList, int row, int col) {
        if (ladderStatus.get(row).get(col) == State.EXIST) {
            Collections.swap(tempList, col, col + 1);
        }
    }

    /**
     * 사다리 모양 출력 메서드입니다.
     */
    public void printLadder() {
        printNames(names);

        for (int i = 0; i < ladderHeight; i++) {
            System.out.print("  |");

            //ladderStatus.get(i).stream().forEach(
            //        s -> System.out.print("" + (s == State.EXIST ? "-----" : "     ") + "|")
            //);
            printLadderRow(i);

            System.out.println();
        }

        printNames(resultNames);
    }

    /**
     * PrintLadder 의 반복 depth 를 줄이기 위해 Row 처리를 따로 메서드화했습니다.
     *
     * @param row 처리할 행번호
     */
    private void printLadderRow(int row) {
        for (int i = 0; i < memberNum; i++) {
            System.out.print(ladderStatus.get(row).get(i) == State.EXIST ? ConstStringSpace.LADDER_BRIDGE : ConstStringSpace.LADDER_NONCONECT);
            System.out.print("|");
        }
    }

    /**
     * 이름과 결과를 출력하기 위한 메서드입니다.
     *
     * @param stringList 이름과 결과를 저장한 List
     */
    private void printNames(List<String> stringList) {
        stringList.stream().forEach(s -> {
            System.out.print(" ".repeat((ConstStringSpace.MAX_NAME_LENGTH - s.length()) / 2));
            System.out.print(s);
            System.out.print(" ".repeat((ConstStringSpace.MAX_NAME_LENGTH - s.length()) / 2));
            System.out.print(" ");
        });
        System.out.println();
    }

    /**
     * 전체 결과를 보여주는 로직입니다.
     */
    public void printAllResult() {
        System.out.println(ConstStringSpace.SHOW_RESULT);

        for (String key : result.keySet()) {
            System.out.println(key + ConstStringSpace.KEY_VALUE_SEPERATOR + result.get(key));
        }
        System.out.println();
    }

    /**
     * 특정 이름의 결과를 보여주는 로직입니다.
     *
     * @param name 보고 싶은 유저의 이름
     */
    public void printResult(String name) {
        System.out.println(ConstStringSpace.SHOW_RESULT);

        System.out.println(result.get(name));
        System.out.println();
    }

    /**
     * immutable 을 지키기 위해 names 를 그냥 반환하는 것이 아니라 새로 생성해서 반환해보았습니다.
     *
     * @return 새로 생성한 names 객체
     */
    public List<String> getNames() {
        return names.stream().collect(Collectors.toList());
    }


}