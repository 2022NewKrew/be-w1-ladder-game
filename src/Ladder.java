import java.util.ArrayList;

public class Ladder {
    private ArrayList<ArrayList<Character>> ladder;
    private int people;
    private int height;

    public Ladder(int people, int height) {
        this.people = people;
        this.height = height;
        ladder = new ArrayList<>();

        for(int i=0; i<height; i++)
            ladder.add(new ArrayList<>());
    }

    public String printLadder(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<height; i++){
            sb.append("|");
            ladder.get(i).forEach(c -> sb.append(c).append("|"));
            sb.append("\n");
        }

        return sb.toString();
    }

    public void createLadder(){
        for(int i=0; i<height; i++){
            createLine(i);
        }
    }

    private void createLine(int height){
        for(int i=0; i<people-1; i++) {
            ladder.get(height)
                    .add((int)(Math.random() * 2) == 0 ? ' ' : '-');
            duplicatedChange(height, i);
        }
    }

    private void duplicatedChange(int height, int people){
        if(people <= 0 || ladder.get(height).get(people) == ' ')
            return;

        if(ladder.get(height).get(people-1) == '-') {
            int rand = (int)(Math.random() * 2);
            ladder.get(height).set(people-rand, ' ');
        }
    }
}
