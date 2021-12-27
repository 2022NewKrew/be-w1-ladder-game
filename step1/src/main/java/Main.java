import java.io.IOException;
import java.util.*;
import main.Ladder;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Ladder ladder = new Ladder();

        System.out.println("참여 할 사람은 몇 명인가요?");
        setLadderVariable(ladder,"numOfPeople");

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        setLadderVariable(ladder,"height");

        //입력받은 정보에 따라 사다리 모양을 콘솔에 출력합니다.
        ladder.drawArrayLadder();
    }


    // variable 옵션에 따라 ladder의 변수를 설정합니다.
    private static void setLadderVariable(Ladder ladder,String variable){
        int input = sc.nextInt();
        if(variable.equals("numOfPeople")){
            ladder.setNumOfPeople(input);
        }
        if(variable.equals("height")){
            ladder.setHeight(input);
        }
    }
}
