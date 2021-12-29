import game.Game;
import game.LadderGame;
import game.frontendapi.apptouser.UserScreenOutputConsole;
import game.frontendapi.usertoapp.UserInputInteger;

public class App {
    public static void main(String[] args) {
        // 실행할 게임을 선택, 유저와의 인터페이스 객체를 생성하여 주입
        Game game = new LadderGame(new UserInputInteger(), new UserScreenOutputConsole());

        // 게임 초기화(유저 입력)
        game.init();
        // 게임 실행
        game.start();
        // 게임 결과출력
        game.printResult();
    }
}
