package laddergame.view;

import java.util.ArrayList;
import java.util.List;

public class StringEditor {
    // 입력받은 이름들을 쉼표를 기준으로 나누어 담는 메소드
    public List<String> nameSplit(String playerNames){
        List<String> playerName = new ArrayList<>();
        for(String name: playerNames.split(","))
            playerName.add(name);
        return playerName;
    }

    // 라벨링하기 위해 이름의 길이를 일정하게 패딩하는 메소드
    public String paddingName(String name, int max_len){
        String lpad = " ";
        String rpad = " ";
        int remaining = max_len - name.length();

        int left = remaining / 2;
        int right = remaining / 2 + remaining % 2;

        return lpad.repeat(left) + name + rpad.repeat(right);
    }
}
