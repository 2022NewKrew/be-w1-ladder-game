package input;

import dto.LadderInputRawData;
import validator.Validator;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static validator.Validator.*;

public class CommandLineInputController implements InputController {
    private static final String commaSeparationRegex = "\\s*,\\s*";
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public LadderInputRawData inputLadderRawData() {
        try {
            List<String> participantsNames = typeParticipants();
            List<String> gameResults = typeGameResultsLine();
            checkParticipantsNameSizeAndGameResultsSize(participantsNames.size(), gameResults.size());
            int heights = typeHeights();
            return new LadderInputRawData(participantsNames.size(), heights, participantsNames, gameResults);
        }catch (IllegalArgumentException e){
            System.out.println("실행 결과의 갯수와 사람의 수는 일치하여야 합니다.");
            return inputLadderRawData();
        }
    }

    @Override
    public String inputNameForResult(Set<String> participantsNames) {
        try {
            System.out.println("결과를 보고 싶은 사람은?");
            String name = sc.nextLine();
            Validator.containsName(name, participantsNames);
            return name;
        }catch (IllegalArgumentException e){
            System.out.println("참가자의 이름을 정확하게 입력해야합니다.");
            return inputNameForResult(participantsNames);
        }
    }

    @Override
    public void close() {
        sc.close();
    }

    private List<String> typeGameResultsLine() {
        try{
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String GameResultsNoSeparated = sc.nextLine();
            List<String> GameResultsLine = List.of(GameResultsNoSeparated.split(commaSeparationRegex));
            checkGameResultsLength(GameResultsLine);
            return GameResultsLine;
        } catch (IllegalArgumentException e){
            System.out.println("각 실행결과는 5글자 이하이어야 합니다.");
            return typeGameResultsLine();
        }
    }

    private List<String> typeParticipants() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String oneLineParticipantsNames = sc.nextLine();
            List<String> participantsNames = List.of(oneLineParticipantsNames.split(commaSeparationRegex));
            checkNameLength(participantsNames);
            return participantsNames;
        } catch (IllegalArgumentException e) {
            System.out.println("참여할 사람의 이름은 5글자 이하이어야 합니다.");
            return typeParticipants();
        }
    }

    private int typeHeights() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int heights = Integer.parseInt(sc.nextLine());
            checkPositiveInteger(heights);
            return heights;
        } catch (IllegalArgumentException e) {
            System.out.println("양의 정수를 입력해주세요");
            return typeHeights();
        }
    }
}
