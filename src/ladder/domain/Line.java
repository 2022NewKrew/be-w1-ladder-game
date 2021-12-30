package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> cells = new ArrayList<>();
    private static final Random random = new Random();
    private static boolean stepExist = true; // -> 아래에서 자주 사용돼서 쓰고 보기 쉽게 쓰고 싶은데 class 바깥으로 빼도 되는지..?
    private static boolean stepNotExist = false;

    // step이 있을 수 있는 크기인 (numPeople - 1) 수 만큼 Line 길이 지정
    public Line (int numPeople) {
        boolean prevStep = false;// if there was a step right before, prevStep = true
        for(int i=0; i<numPeople-1; i++){
            prevStep = buildStep(prevStep, this.cells, stepNotExist);
        }
    }
    public ArrayList<Boolean> getCells(){
        return cells;
    }

    // build base steps for each cell using positions
    public boolean buildStepsPerCell(ArrayList<Boolean> cells){
        boolean randomBool = random.nextBoolean();

        if (randomBool) { // make each step by 50% probability
            cells.add(stepExist);
            return true;
        }
        cells.add(stepNotExist);;
        return false;
    }


    public boolean buildStep(boolean prevStep, ArrayList<Boolean> cells, boolean existOrNot) {
        // build empty step if the previous step is exists in the same line.
        if (prevStep){
            cells.add(existOrNot);
            return stepNotExist;
        }
        return this.buildStepsPerCell(this.cells);

    }


}