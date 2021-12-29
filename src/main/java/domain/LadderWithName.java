package domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class LadderWithName extends Ladder{

    private final List<String> names;
    private Map<String, Integer> nameToNumMap = new ConcurrentHashMap<>();

    public LadderWithName(int people, int height, List<String> names) {
        super(people, height);
        this.names = names;
        int num = 0;
        // name - 사다리 숫자 Map
        IntStream.range(0, names.size()).forEach(i -> nameToNumMap.put(names.get(i), i));
    }

    public List<String> getNames() {
        return names;
    }
}
