package com.chanminkim.w1.service;

import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderGame;
import com.chanminkim.w1.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameService {
    private final LadderService service = new LadderService();

    public LadderGame buildLadderGame(LadderGameDTO dto) {
        Ladder ladder = service.buildLadder(dto.getPlayers().size(), dto.getHeightOfLadder());
        List<Player> players = dto.getPlayers().stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
        return new LadderGame(players, ladder);
    }
}
