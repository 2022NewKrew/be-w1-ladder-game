import java.util.Scanner;

public class InputManager {
    private static final Scanner sc = new Scanner(System.in);

    public static StartInfo makeStartInfo(){
        System.out.println("참여할 사람은 몇 명인가요?");
        int numPeople = makeInputNumber();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = makeInputNumber();

        return new StartInfo(numPeople, maxHeight);
    }
    private static int makeInputNumber(){
        while(true){
            try{
                int value = Integer.parseInt(sc.nextLine());
                checkIntValue(value);
                return value;
            }
            catch(NumberFormatException e){
                System.out.println("양의 정수를 입력해주세요.");
            }
        }
    }
    private static int checkIntValue(int value){
        if(value <=0){
            throw new NumberFormatException();
        }
        return value;
    }
}


