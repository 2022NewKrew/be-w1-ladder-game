package view;

import domain.Ladder;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public InputView(){
    }

    public String[] getParticipants(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String str = sc.nextLine();
        String[] participants = str.split(",");
        return participants;
    }

    public int getHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        sc.close();
        return height;
    }
}
