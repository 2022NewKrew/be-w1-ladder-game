package ladder.stratgey;

// 브릿지 생성 관련 팩토리 패턴
public class LadderStrategyFactory {
    private static final String RANDOM_STRATEGY = "RANDOM";

    public LadderStrategy getLadderStrategy(String type) {
        if (RANDOM_STRATEGY.equals(type)) {
            return new LadderRandomStrategy();
        }
        return null;
    }
}
