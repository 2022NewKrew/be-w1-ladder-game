package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final Random random = new Random();

    private final List<List<ComponentType>> componentMap;

    public Ladder(int numberOfPeople, int ladderHeight) {
        componentMap = createMap(numberOfPeople, ladderHeight);
    }

    private List<List<ComponentType>> createMap(int numberOfPeople, int ladderHeight){
        List<List<ComponentType>> map = new ArrayList<>();

        for(int row=0; row < ladderHeight; row++){
            map.add(createRow(2 * numberOfPeople - 1));
        }

        return map;
    }

    private List<ComponentType> createRow(int rowSize){
        List<ComponentType> components = new ArrayList<>();

        components.add(createComponent(ComponentType.NONE, 0));
        ComponentType prevType = ComponentType.NONE;

        for(int col=1; col < rowSize; col++){
            components.add(createComponent(prevType, col));
            prevType = components.get(components.size()-2);
        }

        return components;
    }

    private ComponentType createComponent(ComponentType prevType, int col){
        if(isLine(col)){
            return ComponentType.LINE;
        }

        if(isEmpty(prevType)) {
            return ComponentType.EMPTY;
        }

        return ComponentType.LADDER;
    }

    private boolean isLine(int col){
        return col % 2 == 0;
    }

    private boolean isEmpty(ComponentType prevType){
        return prevType == ComponentType.LADDER || !random.nextBoolean();
    }

    @Override
    public String toString() {
        return componentMap.stream()
                .map(list -> list.stream().map(ComponentType::getShape).collect(toList()))
                .map(list -> String.join("", list).concat("\n"))
                .reduce("", String::concat);
    }
}
