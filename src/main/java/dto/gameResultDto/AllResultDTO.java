package dto.gameResultDto;

import domain.gameResult.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllResultDTO {
    public List<Map.Entry<String, String>> results;

    private AllResultDTO(Set<Map.Entry<String, String>> results) {
        this.results = new ArrayList<>(results);
    }

    public static AllResultDTO getAllResultDTO(GameResult gameResult) {
        return new AllResultDTO(gameResult.getResult());
    }

    public List<Map.Entry<String, String>> getResults() {
        return results;
    }
}
