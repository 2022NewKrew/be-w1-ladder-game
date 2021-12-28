public class Main {

    public static void main(String[] args) {
        PositiveIntScanner scanner = new PositiveIntScanner();
        int numParticipants = scanner.getPositiveIntWithQuestion("참여할 사람은 몇 명인가요?");
        int maxLadderHeight = scanner.getPositiveIntWithQuestion("최대 사다리 높이는 몇 개인가요?");
        Ladder ladder = new Ladder(numParticipants, maxLadderHeight);
        ladder.draw();
    }
}
