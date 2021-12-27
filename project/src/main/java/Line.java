import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    Line(int countOfPerson){
        for(int i=0; i<countOfPerson; i++){
            if(Math.random() > 0.5){
                points.add(true);
                continue;
            }
            points.add(false);
        }
    }

    public String printLine(){
        StringBuilder result = new StringBuilder("|");
        for(int i = 0; i<points.size(); i++){
            if(points.get(i) == true){
                result.append("-|");
                continue;
            }
            result.append(" |");
        }
        return result.toString();
    }
}
