package game;

import java.util.ArrayList;
import java.util.Random;

public class LadderRow {
    private final int numOfPerson;
    private final Random random = new Random();
    private ArrayList<String> elementList = new ArrayList<>();

    public LadderRow(int numOfPerson) {
        this.numOfPerson = numOfPerson;
        //사람 수 - 1 만큼 element가 있어야 함.
        for(int i = 0; i<numOfPerson-1; i++)
        {
            if (random.nextBoolean())
                elementList.add("-");
            else
                elementList.add(" ");
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        for(String element : elementList)
        {
            stringBuilder.append(element.toString());
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
