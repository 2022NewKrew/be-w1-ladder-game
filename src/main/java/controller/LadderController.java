package controller;

import domain.GamePlay;
import domain.Ladder;
import domain.NameRepository;
import view.LadderView;
import view.NameView;
import view.ResultView;

import java.util.Arrays;
import java.util.Scanner;

public class LadderController {

    private int personNum, ladderHeight;
    NameRepository names;
    NameRepository results;
    Scanner sc = new Scanner(System.in);

    public LadderController() {
        read();
        showLadder();
        showResult();
    }

    public void read() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = new NameRepository(Arrays.asList(sc.nextLine().split(",")));
        names.validationCheck();
        personNum = names.getLength();

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        results = new NameRepository(Arrays.asList(sc.nextLine().split(",")));
        results.validationCheck();
        results.validationCheck(personNum);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = sc.nextInt();
    }

    public void showLadder() {
        NameView nv = new NameView(names);
        nv.printNames();

        Ladder ladder = new Ladder(personNum, ladderHeight);
        LadderView lv = new LadderView(ladder.getLadder());
        lv.printLadder();

        GamePlay gp = new GamePlay(names, ladder);

        NameView result = new NameView(results);
        result.printNames();
    }

    public void showResult(){
        ResultView rv = new ResultView(names, results);
        boolean flag = true;
        sc.nextLine();
        while(flag){
            System.out.println("결과를 보고 싶은 사람은?");
            String input = sc.nextLine();
            flag = questionMapping(rv, input);
            System.out.println();
        }
    }

    private boolean questionMapping(ResultView rv, String s){
        if(s.equals("all")){
            rv.viewAll();
            return true;
        }
        if(s.equals("춘식이")){
            rv.terminate();
            return false;
        }
        rv.viewOne(s);
        return true;
    }
}
