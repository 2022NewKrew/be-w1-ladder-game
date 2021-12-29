package dto;

import java.util.List;

public class LadderInputInfo {
    private final int width;
    private final int height;
    private final List<String> participants;

    public LadderInputInfo(int width, int height, List<String> participants) {
        this.width = width;
        this.height = height;
        this.participants = participants;
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
}
