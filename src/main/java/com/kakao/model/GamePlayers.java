package com.kakao.model;

// 게임 플레이어
public class GamePlayers {
    String[] players;

    // 생성자
    public GamePlayers(String[] players) {
        this.players = players;
    }

    // Getter
    public String[] getPlayers() {
        return players;
    }
    public int getNumberOfPlayers() { // 참여한 사람 수를 반환
        return players != null ? players.length : 0; // 사람이 없으면 0으로 취급
    }
}
