package ladder.stratgey;

// 브릿지 생성 관련 팩토리 패턴
public class LadderStrategyFactory {
    public LadderStrategy getLadderStrategy(String type) {
        if ("random".equals(type)) {
            return new LadderRandomStrategy();
        }
        return null;
    }
}
