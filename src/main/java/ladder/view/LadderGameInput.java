package main.java.ladder.view;

import main.java.ladder.domain.Ladder;

import static java.lang.System.exit;
import static main.java.Application.sc;

public class LadderGameInput {
    public void playGame(Ladder ladder, LadderInput input) {
        LadderGameView ladderGameView = new LadderGameView(ladder, input.getPlayers(), input.getResults());

        String nullInput = sc.nextLine();
        while(true){
            System.out.println("결과를 보고 싶은 사람은?");
            String player = sc.nextLine();
            endGame(player);
            System.out.println(ladderGameView.printResult(player));
        }
    }

    private void endGame(String player){
        if(player.equals("춘식이")){
            sc.close();
            System.out.println("게임을 종료합니다.");
            exit(0);
        }
    }
}