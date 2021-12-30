package com.kakaocorp.laddergame.ladder.domain;

import com.kakaocorp.laddergame.ladder.domain.dto.LadderQueryDto;
import com.kakaocorp.laddergame.ladder.domain.dto.ResultPair;
import com.kakaocorp.laddergame.ladder.domain.dto.ResultTriple;

import java.util.*;
import java.util.stream.Collectors;

public class NameLadder extends Ladder {

    private List<String> members;
    private List<String> results;

    @Override
    public boolean start() {
        Scanner sc = new Scanner(System.in);

        ResultTriple<Boolean, Integer, List<String>> resultQueryMembers = queryMembers(sc);
        if (!resultQueryMembers.getFirst()) {
            return false;
        }
        ResultPair<Boolean, List<String>> resultQueryResults = queryResults(sc);
        if (!resultQueryResults.getFirst()) {
            return false;
        }
        ResultPair<Boolean, Integer> resultQueryHeight = queryHeight(sc);
        if (!resultQueryHeight.getFirst()) {
            return false;
        }
        sc.close();
        update(new LadderQueryDto(resultQueryMembers.getSecond(), resultQueryHeight.getSecond(), resultQueryMembers.getThird(), resultQueryResults.getSecond()));
        return true;
    }

    private ResultPair<Boolean, List<String>> queryResults(Scanner sc) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        System.out.println("ex) 꽝,5000,꽝,3000");
        List<String> results = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return new ResultPair<>(true, results);
    }

    private ResultPair<Boolean, Integer> queryHeight(Scanner sc) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int heightResult = 0;
        try {
            heightResult = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 값을 입력하셨어요. 숫자를 입력해주세요.");
            sc.next();
            queryHeight(sc);
        }

        return new ResultPair<>(true, heightResult);
    }

    private ResultTriple<Boolean, Integer, List<String>> queryMembers(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        System.out.println("ex) pobi,honux,crong,jk");
        List<String> membersResult = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return new ResultTriple<>(true, membersResult.size(), membersResult);
    }

    @Override
    public void makeLines() {
        lines = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            Line line = new Line(getNumber());
            lines.add(line);
        }
    }

    public List<String> getMembers() {
        return members;
    }

    public List<String> getResults() {
        return results;
    }

    public void update(LadderQueryDto queryDto) {
        this.height = queryDto.getHeight();
        this.number = queryDto.getNumber();
        this.members = queryDto.getMembers();
        this.results = queryDto.getResults();
    }
}
