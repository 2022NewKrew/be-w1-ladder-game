package com.chanminkim.w1.view;

import com.chanminkim.w1.controller.LadderGameController;
import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderGame;
import com.chanminkim.w1.model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderOutputView {
    private static final Integer NAME_WIDTH = 5;

    private final LadderGameController controller = new LadderGameController();
    private final LadderGameDTO dto;

    public LadderOutputView(LadderGameDTO dto) {
        this.dto = dto;
    }

    public void printLadderGame() {
        LadderGame ladderGame = controller.buildLadderGame(this.dto);
        System.out.println("실행결과\n");
        printPlayers(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
    }

    private void printPlayers(List<Player> players) {
        String playerLine = players.stream()
                .map(player -> padName(player.getName()))
                .collect(Collectors.joining());
        String leftPadding = " ";
        System.out.println(leftPadding + playerLine);
    }

    private String padName(String name) {
        String defaultPadding = " ";
        if (name.length() >= NAME_WIDTH) {
            return defaultPadding + name;
        }
        int difference = NAME_WIDTH - name.length();
        String leftPadding = " ".repeat(difference / 2 + difference % 2);
        String rightPadding = " ".repeat(difference / 2);
        return defaultPadding + leftPadding + name + rightPadding;
    }

    private void printLadder(Ladder ladder) {
        String defaultPadding = " ".repeat(4);
        String paddedLadder = Arrays.stream(LadderConverter.convertToString(ladder)
                .split("\n"))
                .map(line -> defaultPadding + line)
                .collect(Collectors.joining("\n"));
        System.out.println(paddedLadder);
    }
}
