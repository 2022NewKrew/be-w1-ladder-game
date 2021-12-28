import java.util.Random;

public class LadBuilder {
    int width;

    public LadBuilder() {
    }

    public Ladder buildLadder(int height, int people) {
        width = people * 2 - 1;
        char[][] ladder_temp = new char[height][];
        for (int i = 0; i < height; i++) {
            ladder_temp[i] = buildRow();
        }
        return new Ladder(height, width, ladder_temp);
    }

    private char[] buildRow(){
        char[] row = new char[width];
        for(int i=0; i<width; i++){
            row[i] = getChar(i);
        }
        return row;
    }

    private char getChar(int index){
        if(index%2==0) return '|';
        return getRandomChar();
    }

    private char getRandomChar() {
        Random random = new Random();
        return random.nextBoolean() ? '-' : ' ';
    }
}
