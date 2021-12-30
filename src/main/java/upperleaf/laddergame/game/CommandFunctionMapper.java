package upperleaf.laddergame.game;

import upperleaf.laddergame.domain.LadderFlow;

import java.util.function.Function;

/**
 * mapCommandToFunction(String)은 전달받은 값에 따라 적절한 함수 객체를 반환합니다.
 * ALL일 경우 모든 사용자 이름과 결과를 출력하는 Function을 반환합니다.
 * END일 경우 False를 무조건 반환하는 Function을 반환합니다.
 * 둘 다 아닐 경우 사용자 이름 한개와 결과를 출력하는 Function을 반환합니다.
 */
class CommandFunctionMapper {
    private static final String ALL = "ALL";
    private static final String END = "춘식이";

    public static Function<LadderFlow, Boolean> mapCommandToFunction(String command) {
        if(command.equalsIgnoreCase(ALL)) {
            return new AllFlowFunction();
        }
        if(command.equalsIgnoreCase(END)) {
            return new EndFunction();
        }
        return new FlowFunction(command);
    }

    private static class FlowFunction implements Function<LadderFlow, Boolean> {
        private final String playerName;

        FlowFunction(String playerName) {
            this.playerName = playerName;
        }

        @Override
        public Boolean apply(LadderFlow ladderFlow) {
            String result = ladderFlow.progress(playerName);
            System.out.println("실행 결과");
            System.out.println(result + '\n');
            return true;
        }
    }

    private static class AllFlowFunction implements Function<LadderFlow, Boolean> {

        @Override
        public Boolean apply(LadderFlow ladderFlow) {
            System.out.println("실행 결과");
            ladderFlow.progressAll().forEach((playerName, result) -> {
                System.out.println(playerName + " : " + result);
            });
            System.out.println();
            return true;
        }
    }

    private static class EndFunction implements Function<LadderFlow, Boolean> {

        @Override
        public Boolean apply(LadderFlow ladderFlow) {
            System.out.println("게임을 종료합니다.");
            return false;
        }
    }
}
