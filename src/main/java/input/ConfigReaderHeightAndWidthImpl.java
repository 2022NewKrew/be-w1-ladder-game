package input;

import java.util.Scanner;

public class ConfigReaderHeightAndWidthImpl implements ConfigReader {

    // 사다리 설정정보를 받아서 LadderConfig 객체를 반환
    @Override
    public LadderConfig readLadderConfig(){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            int width = sc.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = sc.nextInt();
            return new LadderConfig(width, height);
        }
    }
}
