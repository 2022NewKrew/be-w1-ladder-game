package com.kakao.ladder.step3;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public Line() {

    }

    // 마지막 값을 제공
    public boolean getLast() {
        return getBridge(getSize() - 1);
    }

    // 전체 개수를 제공
    public int getSize() {
        return points.size();
    }

    // 값을 추가
    public void addLine(boolean isBridge) {
        points.add(isBridge);
    }

    // 해당 index 값을 제공
    public boolean getBridge(int index) {
        return points.get(index);
    }

    // toString에 쓰이는 method. boolean 값에 맞게 bridge를 string으로 만들어준다.
    private String makeBridge(boolean isBridge) {
        if(isBridge)
            return "-----";
        return "     ";
    }

    // Line을 String으로 변환해준다.
    public String toString() {
        sb.setLength(0);
        for(int i=0;i<getSize();i++) {
            sb.append('|');
            sb.append(makeBridge(getBridge(i)));
        }
        sb.append('|');
        return sb.toString();
    }
}
