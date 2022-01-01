package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static util.LadderUtil.*;

public class LadderView {

    private final int GAP = 5;

    public Ladder ladderObject;

    public LadderView(Ladder ladderObject) {
        this.ladderObject = ladderObject;
    };



    public void setValue(String fullName, String destination, Long height) {

        inputValidationCheckName(fullName);
        inputValidationCheckHeight(height);

        ladderObject.setNames(Arrays.asList(fullName.split(",")));
        ladderObject.setDestination(Arrays.asList(destination.split(",")));
        ladderObject.setPeopleCount(ladderObject.getNames().size());
        ladderObject.setHeight(height);
    }


    public static String inputName(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }

    public static String inputDestination(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine();
    }


    public static Long inputHeight(){

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Scanner(System.in).nextLong();
    }

    private void inputValidationCheckHeight(Long height){

        if (height <= 0) {
            throw new IllegalArgumentException("HeightBelowZero");
        }
    }

    private void inputValidationCheckName(String fullName) {
        List<String> nameTemp =  Arrays.asList(fullName.split(","));
        for(int i = 0 ; i < nameTemp.size() ; i++){
            if(nameTemp.get(i).length() <= 0 || nameTemp.get(i).contains(" ")){ //공백이 존재하거나 길이가 0인경우 예외처리
                throw new IllegalArgumentException("Space_Inside_Name");
            }
        }

    }


    public void display() {

        System.out.println("실행결과");
        printName();
        for(int i = 0 ; i < ladderObject.getHeight() ; i++) {
            System.out.print(" ".repeat((GAP + 1) / 2));
            printLine(i); //ith height에 대한 정보를 출력
            System.out.print("\n");
        }
        printDestination();
    }

    private void printName(){
        for(int i = 0 ; i < ladderObject.getNames().size() ; i++){
            System.out.printf("%6s", ladderObject.getNames().get(i));
        }
        System.out.print("\n");
    }

    private void printDestination(){
        for(int i = 0 ; i < ladderObject.getDestination().size() ; i++){
            System.out.printf("%6s", ladderObject.getDestination().get(i));
        }
        System.out.print("\n");
    }

    private void printLine(int line){

        StringBuilder sb = new StringBuilder();
        int lineIdx = 0;
        for(int j = 0 ; j < ladderObject.getPeopleCount() ; j++) {
            sb.append("|");
            sb.append( (lineIdx < ladderObject.getLineStatus().get(line).value.size() && ladderObject.getLineStatus().get(line).value.get(lineIdx) == j ? "-" : " ").repeat(GAP) );

            //updating lineIdx
            lineIdx = updateLineIdx(line, j, lineIdx);
        }
        System.out.print(sb);
        sb.setLength(0);

    }


    private int updateLineIdx(int line, int column, int lineIdx) {

        //lineIdx 변수 갱신
        while(lineIdx < ladderObject.getLineStatus().get(line).value.size() && ladderObject.getLineStatus().get(line).value.get(lineIdx) == column ) {
            lineIdx++;
        }
        return lineIdx;
    }

}
