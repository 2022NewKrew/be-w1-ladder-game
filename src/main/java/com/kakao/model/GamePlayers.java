package com.kakao.model;

import com.kakao.data.LadderOption;
import com.kakao.exception.PlayerFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 게임 플레이어
public class GamePlayers {
    List<String> players; // 리스트로 수정

    // 생성자
    public GamePlayers(String[] players) throws PlayerFormatException {
        checkFormatOfPlayers(players);
        this.players = Arrays.asList(players);
    }

    // Getter
    public String[] getPlayers() {
        String[] returnData = new String[players.size()];
        players.toArray(returnData);
        return returnData;
    }
    public int getNumberOfPlayers() { // 참여한 사람 수를 반환
        return players != null ? players.size() : 0; // 사람이 없으면 0으로 취급
    }

    // 검사함
    private static void checkFormatOfPlayers(String[] data) throws PlayerFormatException {
        for(String player : data) {
            checkFormatOfPlayer(player);
        }
    }
    private static void checkFormatOfPlayer(String data) throws PlayerFormatException {
        if(data.length() > LadderOption.MAX_PLAYER_NAME_LENGTH){
            throw new PlayerFormatException();
        }
    }
}
