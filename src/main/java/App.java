import game.Game;
import game.LadderGame;
import game.frontendapi.apptouser.UserScreenOutputConsole;
import game.frontendapi.usertoapp.UserInputInteger;
import game.frontendapi.usertoapp.UserInputStrings;

public class App {
    public static void main(String[] args) throws Exception{

        // 실행할 게임을 선택, 유저와의 인터페이스 객체를 생성하여 주입
        Game game = new LadderGame(new UserInputStrings(), new UserInputInteger(), new UserScreenOutputConsole());

        // 게임 초기화(유저 입력)
        game.init();
        // 게임 실행
        game.start();
        // 사다리 출력
        game.printResult();
        // 게임 결과출력
        game.printPlayerResult();

    }
}
