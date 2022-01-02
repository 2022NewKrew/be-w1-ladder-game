package com.meg.laddergame.domain;

import com.meg.laddergame.view.InputView;
import com.meg.laddergame.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private List<String> users;
    private List<String> results;
    private Map<String, String> resultsOfUser = new HashMap<>();
    private int height;
    private Ladder ladder;

    public LadderGame() {
    }

    public void start() {
        try {
            setInfo();
            setLadder();
            setResultsOfUser();
            showLadder();
            repeatShowResultOfUser();
        } catch (Exception e) {
            System.out.println("게임을 종료합니다.");
        }
    }

    private void setInfo() {
        users = InputView.askNames();
        results = InputView.askResult();
        height = InputView.askHeight();
    }

    private void setLadder() {
        ladder = new Ladder(users.size(), height);
    }

    private void setResultsOfUser() {
        List<Integer> answers = ladder.getAnswers();
        for (int i = 0; i < users.size(); i++) {
            resultsOfUser.put(users.get(i), results.get(answers.get(i)));
        }
    }

    private void showLadder() {
        OutputView.printLadder(ladder.getLines(), users, results);
    }

    private void repeatShowResultOfUser() {
        while (true) {
            showResultOfUser();
        }
    }

    private void showResultOfUser() {
        String input = InputView.askResultOfUser();
        if (input.equals("all")) {
            OutputView.printResultOfAll(resultsOfUser);
        } else {
            OutputView.printResultOfUser(resultsOfUser, input);
        }
    }
}
