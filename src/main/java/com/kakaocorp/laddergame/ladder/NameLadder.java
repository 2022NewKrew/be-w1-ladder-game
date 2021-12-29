package com.kakaocorp.laddergame.ladder;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class NameLadder extends Ladder {

    final private List<String> rowItems = Arrays.asList("-----", "     ");
    List<String> members;

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

        while (members.size() < 1) {
            System.out.println("입력이 잘못되었습니다. 예시를 참고해주세요. 그만하고 싶으시면 exit를 입력해주세요.");
            members = Arrays.stream(sc.nextLine().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());

            if (members.size() > 0 && members.get(0).equals("exit")) {
                return false;
            }
        }

        System.out.println(members);
        setNumber(members.size());
        return true;
    }

    @Override
    public void makeLadder() {
        ladder = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            ladder.add(makeRow());
        }
    }

    @Override
    public void printLadder() {
        members.forEach(member ->
                System.out.print(StringUtils.leftPad(member, 5, " ") + " ")
        );
        System.out.println();
        ladder.forEach(System.out::println);
    }

    private String makeRow() {
        StringBuilder sb = new StringBuilder();

        sb.append("   |");
        String before = "";
        for (int i = 0; i < getNumber() - 1; i++) {
            String barOrBlank = getBarOrBlank(before);
            sb.append(barOrBlank);
            sb.append("|");
            before = barOrBlank;
        }

        return sb.toString();
    }

    public String getBarOrBlank(String before) {
        if (before.equals(rowItems.get(0))) {
            return rowItems.get(1);
        }

        return rowItems.get(rand.nextInt(rowItems.size()));
    }
}
