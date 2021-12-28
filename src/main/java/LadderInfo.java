public class LadderInfo {
    private final int numParticipants;
    private final int maxLadderHeight;

    private LadderInfo(int numParticipants, int maxLadderHeight) {
        this.numParticipants = numParticipants;
        this.maxLadderHeight = maxLadderHeight;
    }

    public static LadderInfo createByCli() {
        PositiveIntScanner scanner = new PositiveIntScanner();
        int numParticipants = scanner.getPositiveIntWithQuestion("참여할 사람은 몇 명인가요?");
        int maxLadderHeight = scanner.getPositiveIntWithQuestion("최대 사다리 높이는 몇 개인가요?");
        return new LadderInfo(numParticipants, maxLadderHeight);
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }
}
