package com.kakaocorp.laddergame.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class NameLadder extends Ladder {

    private List<String> members;

    @Override
    public boolean start() {
        Scanner sc = new Scanner(System.in);

        if (!queryMembers(sc)) {
            return false;
        }
        if (!queryHeight(sc)) {
            return false;
        }

        sc.close();
        return true;
    }

    private boolean queryHeight(Scanner sc) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            setHeight(sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("잘못된 값을 입력하셨어요. 숫자를 입력해주세요.");
            sc.next();
            queryHeight(sc);
        }

        return true;
    }

    private boolean queryMembers(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        System.out.println("ex) pobi,honux,crong,jk");
        members = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        setNumber(members.size());
        return true;
    }

    @Override
    public void makeLadder() {
        lines = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            Line line = new Line(number);
            lines.add(line);
        }
    }

    public List<String> getMembers() {
        return members;
    }
}
