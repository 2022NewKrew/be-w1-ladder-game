package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFloor {
    private List<Boolean> isConnected;
    private static int maxNameLen = LadderConfig.MAX_NAME_LEN.getValue();

    public LadderFloor(List<Boolean> isConnected) {
        this.isConnected = isConnected;
    }

    public List<Boolean> getIsConnected() {
        return isConnected;
    }

    /**
     * isConnected = {true, false, true, false, false} 일 경우
     *      @return "|-----|     |-----|     |     |";
     */
    @Override
    public String toString() {
        return "|" + IntStream.range(0, isConnected.size())
                .mapToObj(isConnected::get)
                .map(b -> b ? connect() : noConnect()).collect(Collectors.joining());
    }

    /**
     * 현재 이름 최댓값이 5 이므로 리턴값은
     * @return "-----|"
     */
    private String connect() {
        // 현재 이름 최댓값이 5 이므로 리턴값은 -----|
        return "-".repeat(maxNameLen) + "|";
    }

    /**
     * 현재 이름 최댓값이 5 이므로 리턴값은
     * @return "     |"
     */
    private String noConnect() {
        return " ".repeat(maxNameLen) + "|";
    }
}