import java.util.Arrays;
import java.util.Scanner;

public class UserService {
    private Ladder ladder;
    private int height;
    private String[] participants;

    UserService(){
        getInput();
        ladder = new Ladder(participants.length, height);
    }

    public void getInput(){
        Scanner sc = new Scanner(System.in);
        getParticipants(sc);
        getHeight(sc);
        sc.close();
    }

    public void getParticipants(Scanner sc){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String str = sc.nextLine();
        participants = str.split(",");
        System.out.println();
    }

    public void getHeight(Scanner sc){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.height = sc.nextInt();
        System.out.println();
    }

    public void showMap(){
        System.out.println("실행결과");
        System.out.println();
        showParticipants();
        showLadder();
    }

    public void showParticipants(){
        char[] participantsName = new char[(participants.length + 1) * 6];
        Arrays.fill(participantsName,' ');
        for(int i = 0; i < participants.length; i++){
            writeParticipantToCharArr(participantsName, i);
        }
        System.out.println(new String(participantsName));
    }

    public void writeParticipantToCharArr(char[] charArr, int index){
        String participant = participants[index];
        for(int i = 0 ; i < participant.length(); i++){
            charArr[6 * index + 2 - (int)(participant.length() / 2) + i] = participant.charAt(i);
        }
    }

    public void showLadder(){
        ladder.showMap();
    }
}
