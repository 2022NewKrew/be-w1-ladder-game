package view;

import dto.OutputDto;

public class OutputView {
    public static void output(OutputDto outputDto){
        System.out.println(outputDto.getLadderBoard());
    }
}
