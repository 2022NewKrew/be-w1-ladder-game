package factory;

import domain.Ladder;
import dto.InputDto;

public class LadderFactory {
    private static Ladder instance = null;

    public static Ladder getInstance(InputDto inputDto){
        if(instance == null){
            instance = new Ladder(inputDto.getNames(), inputDto.getHeight());
        }

        return instance;
    }
}
