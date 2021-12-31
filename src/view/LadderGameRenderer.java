package view;

import domain.Ladder;

import java.util.List;

public interface LadderGameRenderer {
    void displayGameSettings(List<String> participants, Ladder ladder, List<String> results);
    void displaySentence(String sentence);
}
