import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class IO {
    private static final String qPeopleNames = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String qNumPeople = "참여할 사람은 몇 명인가요?";
    private static final String qMaxHeight = "최대 사다리 높이는 몇 개인가요?";

    private static final char strStep = '-';
    private static final char strEmpty = ' ';
    private static final char strCol = '|';
    private static String multiStrSteps;
    private static String multiStrEmpty;

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

    public void printLadder(Ladder ladder) {
        ArrayList<Line> ladderList = ladder.getLadderList(); //unnecessary
        final int maxNameLength = ladder.getMaxNameLength();
        this.setMultipliedStr(maxNameLength);

        for (Line line : ladderList) {
            ArrayList<Boolean> row = line.getCells();
            String strRow = readRow(row);
            System.out.println(strRow);
        }
    }

    public void setMultipliedStr(int maxNameLength) {
        this.multiStrEmpty = repeat(strEmpty, maxNameLength);
        this.multiStrSteps = repeat(strStep, maxNameLength);
    }


    // read row as string
    public static String readRow(ArrayList<Boolean> row) {
        StringBuilder stringBuilder = new StringBuilder();

        for (boolean isStep : row) {
            stringBuilder.append(strCol);
            stringBuilder = addString(isStep, stringBuilder);
        }
        stringBuilder.append(strCol);

        String strRow = stringBuilder.toString();
        return strRow;
    }

    // add string to stringbuilder according to isStep
    // if isStep==True, add maxStringLength * strStep
    // elif isStep==False, add maxStringLength * strEmpty
    public static StringBuilder addString(boolean isStep, StringBuilder stringBuilder) {
        if (isStep) {
            stringBuilder.append(multiStrSteps);
            return stringBuilder;
        }
        stringBuilder.append(multiStrEmpty);
        return stringBuilder;
    }

    public static String repeat(char str, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <n; i++) {
            sb.append(str);
        }
        String strRow = sb.toString();
        return strRow;
    }



}