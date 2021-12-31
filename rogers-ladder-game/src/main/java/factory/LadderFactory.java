package factory;

import domain.Ladder;
import dto.InputDto;

import java.util.Optional;

public class LadderFactory {
    private static Ladder instance = null;

    public static Optional<Ladder> getInstance(InputDto inputDto){
        if(instance == null){
            Optional<Ladder> newInstanceOptional = createInstance(inputDto);
            newInstanceOptional.ifPresent(ladder -> instance = ladder);
        }

        return Optional.ofNullable(instance);
    }

    private static Optional<Ladder> createInstance(InputDto inputDto){
        try{
            Ladder newInstance = new Ladder(inputDto.getNames(), inputDto.getRewardStrings(), inputDto.getHeight());
            return Optional.of(newInstance);
        }catch (IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException.getMessage());
            return Optional.empty();
        }
    }
}
