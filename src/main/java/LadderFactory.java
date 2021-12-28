import java.util.NoSuchElementException;
import java.util.Scanner;

public class LadderFactory {

    private int peopleSize;
    private int height;

    public LadderFactory() {
        Scanner scanner = new Scanner(System.in);

        this.setupPeopleNum(scanner);
        this.setupHeight(scanner);
    }

    public Ladder buildLadder() {
        return new Ladder(this.peopleSize, this.height);
    }

    private void setupPeopleNum(Scanner scanner) {
        System.out.println("참여할 사람은 몇 명 인가요?");

        try{
            this.peopleSize = scanner.nextInt();
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }
    }

    private void setupHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");

        try{
            this.height = scanner.nextInt();
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }
    }
}
