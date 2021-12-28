import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson){
        for(int i=0; i<countOfPerson-1; i++) {
            line.add(randomValue());
            duplicatedChange(i);
        }
    }

    public ArrayList<Boolean> getLine() {
        return line;
    }

    private boolean randomValue(){
        return ((int)(Math.random() * 2) == 1);
    }

    private void duplicatedChange(int index){
        if(index <= 0 || !line.get(index))
            return;

        if(line.get(index-1))
            line.set(index-(int)(Math.random()*2), false);
    }
}
