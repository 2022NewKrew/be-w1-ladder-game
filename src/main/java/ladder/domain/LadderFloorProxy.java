package ladder.domain;

import java.util.List;

//매번 LadderFloor의 toString이 호출되면 성능상 좋지 않을 것 같아 캐싱을 고민해보는 과정에서 프록시 패턴을 생각하게 되었습니다.
public class LadderFloorProxy extends LadderFloor {
    private String toStr = "";

    public LadderFloorProxy(List<Boolean> connected) {
        super(connected);
    }

    @Override
    public String toString() {
        if (!toStr.isBlank()) return toStr;
        toStr = super.toString();
        return toStr;
    }
}

