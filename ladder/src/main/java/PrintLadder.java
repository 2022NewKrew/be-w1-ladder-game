public class PrintLadder {
    public static void print(Ladder ladder, int height) {
        for (int i = 0; i < height; i++) {
            System.out.println(ladder.ladderInfo.get(i).line);
        }
    }
}
