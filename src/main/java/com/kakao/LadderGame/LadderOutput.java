package com.kakao.LadderGame;

import com.kakao.data.LadderChar;
import com.kakao.data.LadderOption;
import com.kakao.model.Ladder;
import com.kakao.util.TextUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class LadderOutput {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 출력함수
    public static void printLadder(Ladder ladder) {
        // 사다리 전체 출력
        StringBuilder sb = new StringBuilder();
        String[] gamePlayers = ladder.getGamePlayers();
        String[] gameRewards = ladder.getGameRewards();
        List<List<Boolean>> bridgeOfLadder = ladder.getBridgeOfLadder();

        printContents(sb, gamePlayers);
        for(List<Boolean> row: bridgeOfLadder){ // 높이
            printRow(sb, row); // 한 줄을 출력
        }
        printContents(sb, gameRewards);

        try { // 실제 버퍼로 출력 시도
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printRow(StringBuilder sb, List<Boolean> row) { // 한 줄 출력
        // 줄맞춤 용 사다리 공백
        String ladderPrefix = TextUtil.makeRepeatString(LadderChar.LADDER_PREFIX, LadderOption.LADDER_PREFIX_SPACE);
        sb.append(ladderPrefix);

        // 사다리 구성
        sb.append(LadderChar.LADDER_PILLAR); // 첫 막대기
        for(Boolean isBridge: row){ // 너비
            // 중간다리 판단
            String edgeString = printBridge(isBridge);
            String edgeRepeat = TextUtil.makeRepeatString(edgeString, LadderOption.MAX_PLAYER_NAME_LENGTH); // 길이만큼 반복
            sb.append(edgeRepeat);
            sb.append(LadderChar.LADDER_PILLAR);
        }
        sb.append(LadderChar.LADDER_NEWLINE); // 줄바꿈
    }
    private static String printBridge(Boolean isBridge) {
        // 2depth 분리
        return isBridge ? LadderChar.LADDER_BRIDGE : LadderChar.LADDER_SPACE; // 문자 선택
    }
    private static void printContents(StringBuilder sb, String[] gamePlayers) {
        // 참여자 이름 출력
        for(String player: gamePlayers) {
            sb.append(String.format("%"+LadderOption.MAX_PLAYER_NAME_LENGTH+"s ",player));
        }
        sb.append(LadderChar.LADDER_NEWLINE);
    }
}
