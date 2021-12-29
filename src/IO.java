import java.util.ArrayList;
import java.util.Scanner;
public class IO {
    private static final String qPeopleNames = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String qNumPeople = "참여할 사람은 몇 명인가요?";
    private static final String qMaxHeight = "최대 사다리 높이는 몇 개인가요?";

    public IO() {
    }

    public LadderConfig getInput(){
        Scanner scanner = new Scanner(System.in);

        String[] peopleNames = this.getPeopleNames(scanner);
        int nPeople = this.getNumPeople(scanner);
        int maxHeight = this.getMaxHeight(scanner);

        LadderConfig ladderConfig = new LadderConfig(nPeople, maxHeight, peopleNames);
        return ladderConfig;
    }
    public String[] getPeopleNames(Scanner scanner) {
        System.out.println(qPeopleNames);
        String strPeopleNames = scanner.next();
        String[] peopleNames= strPeopleNames.split(",");

        return peopleNames;
    }
    public int getNumPeople(Scanner scanner) {
        System.out.println(qNumPeople);
        int nPeople = scanner.nextInt();
        return nPeople;
    }

    public int getMaxHeight(Scanner scanner) {
        System.out.println(qMaxHeight);
        int maxHeight = scanner.nextInt();
        return maxHeight;
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