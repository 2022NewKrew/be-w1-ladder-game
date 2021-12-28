import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("참여할 사람은 몇 명인가요?");
        int numPeople = inputNumber();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = inputNumber();

        Ladder ladder = new Ladder(numPeople, maxHeight);
        ladder.printLadder();
    }
    static int inputNumber(){
        try{
            int value = Integer.parseInt(sc.nextLine());
            if(value <=0){
                throw new NumberFormatException();
            }
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("양의 정수를 입력해주세요.");
            return inputNumber();
        }
    }
}

