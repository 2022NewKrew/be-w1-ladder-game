package view;

import domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void showParticipants() {
        Ladder ladder = new Ladder(5,5);
        String[] str = {"kim", "jo", "park", "jeong", "k"};
        OutputView outputView = new OutputView(ladder, str);
        assertEquals(outputView.showParticipants(), " kim   jo   park  jeong   k         ");
    }
}