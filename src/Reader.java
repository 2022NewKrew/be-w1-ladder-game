import java.util.Scanner;
public class Reader {
    private int Npeople;
    private int MaxHeight;

    public Reader() {
    }

    public int getMaxheight() {
        return this.MaxHeight;
    }

    public int getNpeople() {
        return this.Npeople;
    }

    public void readNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        this.Npeople = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.MaxHeight = scanner.nextInt();

        System.out.printf("참여인원: %d, 최대 사다리 높이: %d\n",Npeople, MaxHeight);
    }



}
