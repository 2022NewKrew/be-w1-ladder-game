import java.util.Arrays;
import java.util.Scanner;

public class LadderGameStarter {
    private final Scanner sc = new Scanner(System.in);
    private final int maxNameLength;

    public LadderGameStarter(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public String[] getPeople() {
        String[] people;
        do {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            people = sc.next().split(",");
        } while (!isValid(people));

        return people;
    }

    public boolean isValid(String[] people){
        if(Arrays.stream(people).anyMatch(name -> (name.length() > maxNameLength) || name.isEmpty())){
            System.out.println("아래의 조건을 충족하는 지 확인하고 다시 입력해주세요.");
            System.out.println("- 문자열의 길이는 " + maxNameLength + "이하여야 합니다.");
            System.out.println("- 쉼표 사이에 빈 문자열이 있으면 안됩니다.");
            return false;
        }
        return true;
    }

    public int getHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}
