import java.util.Scanner;
public class Reader {
    private int nPeople;
    private int maxHeight;

    public Reader() {
    }

    public int getMaxheight() {
        return this.maxHeight;
    }

    public int getNpeople() {
        return this.nPeople;
    }

    public void readNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        this.nPeople = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.maxHeight = scanner.nextInt();

        System.out.printf("참여인원: %d, 최대 사다리 높이: %d\n",nPeople, maxHeight);
    }



}
