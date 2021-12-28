import java.util.*;

class step1 {

    private static String makeLadder(int p) {
        // 사다리 배열 초기화
        String[] ladder = new String[2*p-1];
        Arrays.fill(ladder, " ");
        for (int i = 0; i < 2*p - 1; i += 2) {
            ladder[i] = "|";
        }

        // 사다리 설치
        int l = (int)(Math.random() * (p-1))*2 + 1;
        ladder[l] = "-";

        return String.join("", ladder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int people = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        // 사다리 만들기
        for (int i = 0; i < height; i++) {
            System.out.println(makeLadder(people));
        }
    }
}
