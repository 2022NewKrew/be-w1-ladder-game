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
    private String multiStrSteps;
    // 아래 함수중에 setMultipliedStr() 에서 해당 변수가 static 이 설정이 안됩니다...ㅜㅜ
    // (원래는 관련 함수들 전부 static이었는데 setMultipliedStr()에서 non-static을 static 내에서 쓸 수 없다는 에러가 떠서 변경했는데
    // 이게 맞을까요??..
    private String multiStrEmpty;


    public IO() {
    }

    public LadderConfig getInput(){
        Scanner scanner = new Scanner(System.in);

        String[] peopleNames = this.setPeopleNames(scanner);
        int nPeople = this.setNumPeople(scanner);
        int maxHeight = this.setMaxHeight(scanner);

        LadderConfig ladderConfig = new LadderConfig(nPeople, maxHeight, peopleNames);
        return ladderConfig;
    }
    public String[] setPeopleNames(Scanner scanner) {
        System.out.println(qPeopleNames);
        String strPeopleNames = scanner.next();
        String[] peopleNames= strPeopleNames.split(",");

        return peopleNames;
    }
    public int setNumPeople(Scanner scanner) {
        System.out.println(qNumPeople);
        int nPeople = scanner.nextInt();
        return nPeople;
    }

    public int setMaxHeight(Scanner scanner) {
        System.out.println(qMaxHeight);
        int maxHeight = scanner.nextInt();
        return maxHeight;
    }

    public void printLadder(Ladder ladder) {
        ArrayList<Line> ladderList = ladder.getLadderList();
        final int maxNameLength = setMultipliedStrings(ladder);

        //print names at the top of ladder
        printHeader(ladder, maxNameLength);

        //print ladders
        for (Line line : ladderList) {
            printRow(line);
        }
    }

    //print names of users at the top of ladder
    public String printHeader(Ladder ladder, int maxNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] names = ladder.getPeopleNames();


        for (String name : names){
            name = preprocessName(name, maxNameLength);
            stringBuilder.append(name);
        }
        stringBuilder = addPadtoHeader(stringBuilder, maxNameLength);
        String strRow = stringBuilder.toString();
        System.out.println(strRow);
        return strRow;
    }

    public static StringBuilder addPadtoHeader(StringBuilder stringBuilder, int maxNameLength) {
        final int offset = maxNameLength/2 +1;
        for(int i=0; i<offset; i++) {
            stringBuilder.insert(0, strEmpty);
        }
        return stringBuilder;
    }

    // if length of name <5 : add padding(' ') to the name
    // if length of name >5 : truncate the name to set its length as 5.
    public static String preprocessName(String name, int maxNameLength) {
        final int nPads = maxNameLength - name.length();
        if (nPads > 0) {
            String paddedName = addPad(name, nPads, maxNameLength);
            return paddedName;
        }
        // [later] should implement when name>5 to avoid error
        String shortedName = truncateName(name, maxNameLength);
        return shortedName;
    }

    //add padding(' ') to the name
    public static String addPad(String name, int nPads, int maxNameLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i < nPads/2; i++) { // add front-padding
            stringBuilder.append(strEmpty);
        }
        stringBuilder.append(name);
        final int leftPads = maxNameLength - stringBuilder.length()+1;

        for(int i=0; i < leftPads; i++) { // add back-padding
            stringBuilder.append(strEmpty);
        }
        String strRow = stringBuilder.toString();
        return strRow;
    }

    // [later] should implement when name>5 to avoid error
    // 조건 주어지면 나중에 구현 예정
    public static String truncateName(String name, int maxNameLength){
        return name;
    }



    //print ladders which consists of steps and cols.
    public void printRow(Line line) {
        ArrayList<Boolean> row = line.getCells();
        String strRow = readRow(row);
        System.out.println(strRow);
    }

    //get maxNameLength from ladder
    //set variable as stringPattern * maxNameLength
    public int setMultipliedStrings(Ladder ladder){
        final int maxNameLength = ladder.getMaxNameLength();
        setMultipliedStr(maxNameLength);
        return maxNameLength;
    }

    public void setMultipliedStr(int maxNameLength) {
        this.multiStrEmpty = repeat(strEmpty, maxNameLength);
        this.multiStrSteps = repeat(strStep, maxNameLength);
    }


    // read row as string from Line of Ladder
    public String readRow(ArrayList<Boolean> row) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(multiStrEmpty); //add left padding

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
    // else isStep==False, add maxStringLength * strEmpty
    public StringBuilder addString(boolean isStep, StringBuilder stringBuilder) {
        if (isStep) {
            stringBuilder.append(multiStrSteps);
            return stringBuilder;
        }
        stringBuilder.append(multiStrEmpty);
        return stringBuilder;
    }

    //repeat given character n times -> return string
    public String repeat(char chr, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <n; i++) {
            sb.append(chr);
        }
        String strRow = sb.toString();
        return strRow;
    }



}