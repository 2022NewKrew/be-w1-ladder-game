package ladder.domain;

import java.util.*;
import static util.LadderUtil.*;

public class Ladder {
    private List<String> names;
    private long peopleCount, height;
    private Line[] lineStatus;

    public Ladder() {
    }

    //getter
    public List<String> getNames() {
        return names;
    }

    public long getPeopleCount() {
        return peopleCount;
    }

    public long getHeight() {
        return height;
    }

    public Line[] getLineStatus() {
        return lineStatus;
    }

    public String inputName(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public Long inputHeight(){

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextLong();
    }

    private void inputValidationCheck(String fullName, Long height) throws Exception {
        List<String> nameTemp =  Arrays.asList(fullName.split(","));
        for(int i = 0 ; i < nameTemp.size() ; i++){
            if(nameTemp.get(i).length() <= 0 || nameTemp.get(i).contains(" ")){ //공백이 존재하거나 길이가 0인경우 예외처리
                throw new Exception();
            }
        }

        if(height <= 0){
            throw new Exception();
        }


    }

    public void setValue(String fullName, Long height) throws Exception {

        inputValidationCheck(fullName, height);

        names = Arrays.asList(fullName.split(","));
        this.peopleCount = names.size();
        this.height = height;
    }

    public void initLine() {

        lineStatus = new Line[(int) this.height];
        for(int i = 0 ; i < height ; i++) {
            lineStatus[i] = new Line();
            lineStatus[i].value = new ArrayList<Long>();
        }

    }

    private void checkDeletion(int line, int column){

        //if line inserted sequencial order, delete.
        while(column + 1 < lineStatus[line].value.size() && lineStatus[line].value.get(column) + 1 == lineStatus[line].value.get(column + 1)){
            lineStatus[line].value.remove(column + 1);
        }

    }

    private void validUpdateLine(int line){

        for(int i = lineStatus[line].value.size() - 2 ; i >= 0 ; i--){
            checkDeletion(line, i);
        }

    }

    private void insertLine(int line, int lineSize){

        for(int i = 0 ; i < lineSize ; i++) {
            lineStatus[line].value.add((long) rd.nextInt((int) peopleCount - 1));
        }

        lineStatus[line].value.sort(Long::compareTo);

    }


    public void shuffle() {


        for(int i = 0 ; i < height ; i++) {
            int lineSize = rd.nextInt((int) peopleCount - 1);
            insertLine(i, lineSize); //lineSize 개수의 라인을 i 번째 높이에 랜덤으로 생성.
            validUpdateLine(i); //i번째 height에 연속적인 line이 생성된경우 제거로직 추가
        }

    }







}
