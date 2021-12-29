public class Ladder {
    private final String[] participants;
    private final int maxHeight;
    private final LadderData ladderData;

    public Ladder(String[] participants, int maxHeight) {
        this.participants = participants;
        this.maxHeight = maxHeight;
        ladderData = new LadderData(maxHeight, participants.length - 1);
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public LadderData getLadderData() {
        return ladderData;
    }
}
