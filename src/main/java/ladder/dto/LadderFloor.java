package ladder.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFloor {
    private List<Boolean> isConnected;

    public LadderFloor(List<Boolean> isConnected) {
        this.isConnected = isConnected;
    }

    public List<Boolean> getIsConnected() {
        return isConnected;
    }

    @Override
    public String toString() {
        return "|" + IntStream.range(0, isConnected.size())
                .mapToObj(isConnected::get)
                .map(b -> b ? "-----|" : "     |").collect(Collectors.joining());
    }
}
