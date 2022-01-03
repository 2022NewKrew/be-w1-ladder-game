package dto.gameResultDto;

import domain.gameResult.GameResult;

public class TargetResultDTO {
    private final String result;

    public TargetResultDTO(String result) {
        this.result = result;
    }

    public static TargetResultDTO getTargetResultDTO(GameResult gameResult, String target) {
        return new TargetResultDTO(gameResult.getTargetResult(target));
    }

    public String getResult() {
        return result;
    }
}
