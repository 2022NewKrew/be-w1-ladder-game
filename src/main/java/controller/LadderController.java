package controller;

import domain.Ladder;
import domain.Line;
import domain.NameRepository;
import view.LadderView;
import view.NameView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderController {

    private int personNum, ladderHeight;
    NameRepository names;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = new NameRepository(Arrays.asList(sc.nextLine().split(",")));
        names.validationCheck();
        personNum = names.getLength();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = sc.nextInt();
    }

    public void show(){
        NameView nv = new NameView(names);
        nv.printNames();

        Ladder ladder = new Ladder(personNum, ladderHeight);
        LadderView lv = new LadderView(ladder.getLadder());
        lv.printLadder();
    }
}
