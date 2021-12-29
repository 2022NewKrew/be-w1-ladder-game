package ladder.view;

import ladder.service.LadderService;
import ladder.view.dto.LadderDto;

import java.util.Scanner;

public class LadderController {

    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void startGame() {
        LadderDto ladderDto = getInput();
        ladderService.runLadderGame(ladderDto);
    }

    private LadderDto getInput() {
        Scanner sc = new Scanner(System.in);
        String inputParticipants;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        inputParticipants = sc.nextLine();
        System.out.println("최대 사다리 높이는 얼마인가요?");
        int height = sc.nextInt();

        sc.close();

        return new LadderDto(inputParticipants, height);
    }




}
