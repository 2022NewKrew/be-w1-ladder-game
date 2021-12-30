package laddergame.domain;

import laddergame.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class LadderGameTest {

    @Mock
    private View view;

    @InjectMocks
    private LadderGame ladderGame;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Ladder Game 실행 테스트")
    @Test
    void run() {
        // Given
        List<String> userNameList = new ArrayList<>();
        userNameList.add("lucas");
        userNameList.add("test");
        when(view.readUserName()).thenReturn(userNameList);
        when(view.readLadderCount()).thenReturn(5);
        when(view.readUserNameForGameResult()).thenReturn("춘식이");

        Ladder ladder = new Ladder(4, 5);
        List<User> users = new ArrayList<>();
        User user = new User("lucas");
        users.add(user);

        List<String> gameResultTexts = new ArrayList<>();
        gameResultTexts.add("3000");
        gameResultTexts.add("꽝");

        Map<String, String> gameResult = new HashMap<>();
        gameResult.put("lucas", "3000");
        gameResult.put("test", "꽝");

        doNothing().when(view).printLadderBoard(ladder, users, gameResultTexts);
        doNothing().when(view).printGameResultOfAllUser(gameResult);
        doNothing().when(view).printGameResultOfEachUser(gameResult, "lucas");

        // When
        ladderGame.run();

        // Then
        Mockito.verify(view).readUserName();
        Mockito.verify(view).readLadderCount();
        Mockito.verify(view).readUserNameForGameResult();
    }
}