package view.input.reader;

import view.input.config.LadderConfig;

import java.util.Scanner;

public interface ConfigReader {
    // ladder.Ladder 설정 정보를 읽어오는 함수
    LadderConfig readLadderConfig(Scanner sc);

}
