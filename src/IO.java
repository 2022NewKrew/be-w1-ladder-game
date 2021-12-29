import java.util.Scanner;
public class IO {

    private static final String qNumPeople = "참여할 사람은 몇 명인가요?";
    private static final String qMaxHeight = "최대 사다리 높이는 몇 개인가요?";

    public IO() {
    }

    public static LadderConfig getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(qNumPeople);
        int nPeople = scanner.nextInt();

        System.out.println(qMaxHeight);
        int maxHeight = scanner.nextInt();

        LadderConfig ladderConfig = new LadderConfig(nPeople, maxHeight);
        return ladderConfig;
    }

    public static void printLadder(Ladder ladder) {
        char[][] ladderArr = ladder.getCharArr();
        for (char[] row : ladderArr) {
            String strRow = readRow(row);
            System.out.println(strRow);

        }
    }

    // read row as string
    public static String readRow( char[] row) {
        StringBuilder sb = new StringBuilder();
        for (char ch : row) {
            sb.append(ch);
        }
        String strRow = sb.toString();
        return strRow;
    }



}