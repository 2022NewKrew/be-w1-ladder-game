package com.yapark97.laddergame.ladder.domain.row;

public interface Row {
    int move(int curIndex); // 다음 row로 이동했을 때의 index를 반환

    default String getSimpleOutput(final int WIDTH) {
        return this.toString();
    };
}
