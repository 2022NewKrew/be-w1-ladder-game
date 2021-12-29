package ladder.stratgey;

//사다리 브릿지 생성 전략
public interface LadderStrategy {
    int getBridgeIdx(); // 브릿지 위치 구하기

    int getLineIdx(); // 라인 위치 구하기

    int getBridgeCntBound(int height, int playersCnt); // 브릿지 갯수 바운드 구하기
}
