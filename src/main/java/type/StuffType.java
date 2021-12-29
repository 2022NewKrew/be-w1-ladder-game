package type;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StuffType {
    // 0: 기둥, 1: 다리, 2: 공백
    COLUMN(0, "|"),
    BRIDGE(1, "-----"),
    SPACE(2, "     ");

    private final int num;
    private final String stuff;

    StuffType(int num, String stuff) {
        this.num = num;
        this.stuff = stuff;
    }

    public String getStuff(){
        return stuff;
    }
    public int getNum() { return num; }

    private static final Map<Integer, String> NUM_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(StuffType::getNum, StuffType::name))
    );

    public static StuffType of(final Integer num){
        return StuffType.valueOf(NUM_MAP.get(num));
    }
}
