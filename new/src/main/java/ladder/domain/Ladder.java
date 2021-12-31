package ladder.domain;
import java.util.ArrayList;
import java.util.Arrays;

public class Ladder {
    private final int nPeople;
    private final int maxHeight;
    private final String[] peopleNames;
    private final String[] outputs;
    private final ArrayList<Line> arr;
    private String arrStr;

    private static final char strStep = '-';
    private static final char strEmpty = ' ';
    private static final char strCol = '|';
    private String multiStrSteps = "-----";
    private String multiStrEmpty = "     ";

    private static final int maxNameLength = 5;


    //constructor
    public Ladder(LadderConfig ladderConfig) {
        this.nPeople = ladderConfig.getNumPeople();
        this.maxHeight = ladderConfig.getMaxHeight();
        this.peopleNames = ladderConfig.getPeopleNames();
        this.outputs = ladderConfig.getOutputs();
        this.arr = new ArrayList<Line>();

        buildLines();
        this.arrStr = ladderToStr();
    }

    public String getLadderStr(){
        return this.arrStr;
    }

    //line 생성
    private void buildLines() {
        for (int i = 0; i < this.maxHeight; i++) {
            Line line = new Line(this.nPeople);
            this.arr.add(line);
        }
    }

    //아래는 ladder string으로 표현

    private String ladderToStr() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder backStringBuilder = new StringBuilder();
        ArrayList<Line> ladderList = this.arr;

        //print names at the top of ladder
        stringBuilder = headerToStr(stringBuilder, this.peopleNames);

        //print ladders
        for (Line line : ladderList) {
            rowToStr(stringBuilder, line);
        }
        //print outputs
        headerToStr(backStringBuilder, this.outputs);

        stringBuilder.append(backStringBuilder);

        String strRow = stringBuilder.toString();
        return strRow;
    }

    //print names of users at the top of ladder
    private StringBuilder headerToStr(StringBuilder stringBuilder, String[] names) {

        for (String name : names){
            name = preprocessName(name);
            stringBuilder.append(name);
        }
        stringBuilder = addPadtoHeader(stringBuilder);

        stringBuilder.append('\n');
        return stringBuilder;
    }

    public static StringBuilder addPadtoHeader(StringBuilder stringBuilder) {
        final int offset = maxNameLength/2 +1;
        for(int i=0; i<offset; i++) {
            stringBuilder.insert(0, strEmpty);
        }
        return stringBuilder;
    }

    // if length of name <5 : add padding(' ') to the name
    // if length of name >5 : truncate the name to set its length as 5.
    public static String preprocessName(String name) {
        final int nPads = maxNameLength - name.length();
        // if length of name >5 : truncate first
        if (nPads <= 0 ) {
            String shortedName = truncateName(name);
            return shortedName;
        }

        String paddedName = addPad(name, nPads);
        return paddedName;

    }

    //add padding(' ') to the name
    private static String addPad(String name, int nPads) {
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

    // should implement when name>5 to avoid error
    // put empty string at last for padding
    private static String truncateName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        String shortenName = name.substring(0, maxNameLength);
        stringBuilder.append(shortenName);
        stringBuilder.append(strEmpty);
        String strRow = stringBuilder.toString();
        return strRow;
    }



    //print ladders which consists of steps and cols.
    private StringBuilder rowToStr(StringBuilder stringBuilder, Line line) {
        ArrayList<Boolean> row = line.getCells();
        stringBuilder = readRow(stringBuilder, row);
        stringBuilder.append('\n');
        return stringBuilder;
    }


    // read row as string from Line of Ladder
    private StringBuilder readRow(StringBuilder stringBuilder , ArrayList<Boolean> row) {

        stringBuilder.append(multiStrEmpty); //add left padding

        for (boolean isStep : row) {
            stringBuilder.append(strCol);
            stringBuilder = addString(isStep, stringBuilder);
        }
        stringBuilder.append(strCol);
        return stringBuilder;
    }

    // add string to stringbuilder according to isStep
    // if isStep==True, add maxStringLength * strStep
    // else isStep==False, add maxStringLength * strEmpty
    private StringBuilder addString(boolean isStep, StringBuilder stringBuilder) {
        if (isStep) {
            stringBuilder.append(multiStrSteps);
            return stringBuilder;
        }
        stringBuilder.append(multiStrEmpty);
        return stringBuilder;
    }

    public String runGame(String userName){
        LadderGame ladderGame = new LadderGame(this.arr);
        int userId = Arrays.asList(this.peopleNames).indexOf(userName);
        if (userId==-1){// all
            return "all"; //have to do something
        }
        int outId = ladderGame.getResultIdx(userId);
        return this.outputs[outId];

    }
}

