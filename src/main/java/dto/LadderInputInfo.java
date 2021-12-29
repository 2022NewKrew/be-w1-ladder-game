package dto;

import java.util.List;

public class LadderInputInfo {
    private final int width;
    private final int height;
    private final List<String> participants;
    private List<String> results;

    public LadderInputInfo(int width, int height, List<String> participants) {
        this.width = width;
        this.height = height;
        this.participants = participants;
    }

    public LadderInputInfo(int width, int height, List<String> participants, List<String> results) {
        this.width = width;
        this.height = height;
        this.participants = participants;
        this.results = results;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }
}
