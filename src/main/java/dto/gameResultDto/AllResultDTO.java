package dto.gameResultDto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AllResultDTO {
    public List<Map.Entry<String, String>> results;

    public AllResultDTO(List<Map.Entry<String, String>> results) {
        this.results = Collections.unmodifiableList(results);
    }

    public List<Map.Entry<String, String>> getResults() {
        return results;
    }
}
