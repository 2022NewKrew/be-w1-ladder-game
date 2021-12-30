package view.input.reader;

import view.input.config.LadderConfigWithResult;
import view.input.config.LadderConfig;

import java.util.List;
import java.util.Scanner;

public class ConsoleConfigWithResultReader implements ConfigReader{
    @Override
    public LadderConfig readLadderConfig(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = List.of(sc.nextLine().split(","));
        int peopleCount = names.size();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> results = List.of(sc.nextLine().split(","));
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(sc.nextLine());
        return new LadderConfigWithResult(peopleCount, height, names, results);
    }
}
