import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> line = new ArrayList<>();

    public Line(int numOfPerson){
        for(int i=0; i<numOfPerson-1; i++) {
            line.add(randomValue(i));
        }
    }

    public ArrayList<Boolean> getLine() {
        return line;
    }

    private boolean randomValue(int index){
        if(collisionCheck(index))
            return false;

        return (int)(Math.random()*2) == 1;
    }

    private boolean collisionCheck(int index){
        return index > 0 && line.get(index - 1);
    }
}
