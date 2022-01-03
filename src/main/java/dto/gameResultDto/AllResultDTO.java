package dto.gameResultDto;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllResultDTO {
    public List<Map.Entry<String, String>> results;

    public AllResultDTO(Set<Map.Entry<String, String>> results) {
        this.results = results.stream().toList();
    }

    public List<Map.Entry<String, String>> getResults() {
        return results;
    }
}
