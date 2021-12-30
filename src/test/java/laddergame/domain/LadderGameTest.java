package laddergame.domain;

import laddergame.view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

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

        Ladder ladder = new Ladder(4, 5);
        List<User> users = new ArrayList<>();
        User user = new User("lucas");
        users.add(user);

        doNothing().when(view).printLadderBoard(ladder, users);

        // When
        ladderGame.run();

        // Then
        Mockito.verify(view).readUserName();
        Mockito.verify(view).readLadderCount();
    }
}