import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class InterfaceClass {

    public static int getNumberPeople(){
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public static ArrayList getPeopleList(){
        Scanner sc = new Scanner(System.in);
        String nameLine;
        ArrayList nameArray;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        nameLine = sc.nextLine();
        nameArray = new ArrayList(Arrays.asList(nameLine.split(",")));

        return nameArray;
    }

    public static int getLadderHeight(){
        Scanner sc = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

}
