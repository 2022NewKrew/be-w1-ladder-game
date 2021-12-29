package view.input;

import java.util.List;
import java.util.Scanner;

public class ConfigReaderNameAndHeight implements ConfigReader{
    @Override
    public LadderConfig readLadderConfig() {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = List.of(sc.nextLine().split(","));
            int width = names.size();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = sc.nextInt();
            return new LadderConfigWithName(width, height, names);
        }
    }
}
