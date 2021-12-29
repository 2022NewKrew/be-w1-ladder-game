public class LadderGame {

    /**
     ** 1. 사용자로부터 게임 시작 정보를 입력받습니다.
     ** 2. 사다리를 생성합니다.
     ** 3. 사다리를 출력합니다.
     */
    public static void main(String[] args) {
        GameInputManager manager = new GameInputManager();
        GameStartInfo info = manager.getInputGameStartInfo();

        LadderGenerator generator = new LadderGenerator();
        Ladder ladder = generator.generate(info, new RandomConnector(System.currentTimeMillis()));

        LadderRenderer renderer = new LadderRenderer();
        renderer.render(ladder);
    }

}
