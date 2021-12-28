public class Main {
    public static void main(String[] args) throws IOException {
        Ladder ladder = new Ladder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("참여할 사람은 몇 명인가요?");
        person = Integer.parseInt(br.readLine());
        ladder.setPerson();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladder.setHeight();
        ladder.setWidth();
        ladder.initializeLadder();
        ladder.setLadder();
        ladder.printLadder();
    }
}