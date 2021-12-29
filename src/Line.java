import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> cells = new ArrayList<>();
    private static final Random random = new Random();
    private static boolean stepExist = true;
    private static boolean stepNotExist = false;

    // step이 있을 수 있는 크기인 (numPeople - 1) 수 만큼 Line 길이 지정
    public Line (int numPeople) {
        boolean check = false;
        for(int i=0; i<numPeople-1; i++){
            // if there was a step right before, check = true
            if (check) {
                //if there were a step before, do not add any step.
                this.buildStepAtLast(this.cells, stepNotExist);
                continue;
            }
            check = this.buildStepsPerCell(this.cells);

        }

    }
    public ArrayList<Boolean> getCells(){
        return cells;
    }

    // build base steps for each cell using positions
    public boolean buildStepsPerCell(ArrayList<Boolean> cells){
        float randomFloat = random.nextFloat();

        if (randomFloat <0.5) { // make each step by 50% probability
            buildStepAtLast(cells, stepExist);
            return true;
        }
        buildStepAtLast(cells, stepNotExist);
        return false;
    }

    // build step in the last position of line
    public static void buildStepAtLast(ArrayList<Boolean> cells, boolean existOrNot) {
        cells.add(existOrNot);
    }

    // 라인의 좌표 값에 step('-')이 있는지 유무를 판단하는 로직 추가

}