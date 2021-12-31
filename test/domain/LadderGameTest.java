package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderGameInputManager;
import view.LadderGameRenderer;
import view.StandardInputLadderGameInputManager;
import view.StandardOutLadderGameRenderer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName("사다리 결과 최대 5글자를 넘지 않는가?")
    @Test
    public void 사다리_참여자_결과_최대글자수_확인() {
        //given
        List<String> participants = Arrays.asList("pobi","honux","crong","jk","jeff","binary","clo","keith","hoody","champ","aaaaaa","aas","fdsw","adfe","fdsafg","gdsagsdagsda","asdf","sdfsa","sdf","fewr","qwer","fdvv","fffffa","ssdffs","adsffgg","qwerwer","vcxzv","dsf","w","rqwerfs");
        List<String> results = Arrays.asList("pobi","honux","crong","jk","jeff","binary","clo","keith","hoody","champ","aaaaaa","aas","fdsw","adfe","fdsafg","gdsagsdagsda","asdf","sdfsa","sdf","fewr","qwer","fdvv","fffffa","ssdffs","adsffgg","qwerwer","vcxzv","dsf","w","rqwerfs");
        LadderGameInputManager inputManager = new StandardInputLadderGameInputManager();
        LadderGameRenderer renderer = new StandardOutLadderGameRenderer();

        int cnt = 100;

        while(cnt-- > 0) {
            //when
            LadderGame game = new LadderGame(inputManager, renderer);
            /*
            * participants, results에서 랜덤으로 뽑아서 5글자 제한 잘 지키는지 보려했는데
            * 생각해보니 표준입력이라...
            * 테스트 어떻게 해야할까요..? */

            //then
        }
    }
}