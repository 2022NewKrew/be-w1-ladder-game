package com.chanminkim.w1.service;

import com.chanminkim.w1.controller.LadderGameDTO;
import com.chanminkim.w1.model.LadderGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LadderGameServiceTest {
    @Test
    public void 만들어진_사다리게임의_플레이어수는_주어진_플레이어수와_같아야한다() {
        LadderGameService service = new LadderGameService();
        List<String> players = List.of("pobi", "honux", "crong", "jk");
        LadderGameDTO dto = new LadderGameDTO(players, 5);
        LadderGame ladderGame = service.buildLadderGame(dto);

        Assert.assertEquals(players.size(), ladderGame.getPlayers().size());
    }
}