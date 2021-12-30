package laddergame.domain;

import laddergame.view.GameView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<String> users;
    private List<String> targets;
    private Ladder ladder;
    private Map<String,String> result;

    public void start(){
        users = GameView.inputArrayList("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",");
        targets = GameView.inputArrayList("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", ",");
        ladder = new Ladder(users.size(), GameView.inputInteger("최대 사다리 높이는 몇 개인가요?"));
        result = findResult(users, targets, ladder);
        GameView.printLadderWithLabels(ladder, users, targets);
        progress();
    }

    private Map<String,String> findResult(List<String> users, List<String> targets, Ladder ladder){
        Map<String,String> result = new HashMap<String,String>();
        for(int i=0; i<users.size(); i++){
            result.put(users.get(i), targets.get(ladder.findResultPosition(i)));
        }
        return result;
    }

    private void progress(){
        String user = GameView.inputString("결과를 보고 싶은 사람은?");
        while(!user.equals("춘식이")){
            GameView.printResult(result, user);
            user = GameView.inputString("결과를 보고 싶은 사람은?");
        }
        System.out.println("게임을 종료합니다.");
    }
}
