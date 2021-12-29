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

        for(int col=1; col < rowSize; col++){
            components.add(createComponent(components, col));
        }

        return components;
    }

    private ComponentType createComponent(List<ComponentType> prevTypes, int col){
        if(isLine(col)){
            return ComponentType.LINE;
        }

        if(isEmpty(prevTypes)) {
            return ComponentType.EMPTY;
        }

        return ComponentType.LADDER;
    }

    private boolean isLine(int col){
        return col % 2 == 0;
    }

    private boolean isEmpty(List<ComponentType> prevTypes){
        if(prevTypes.size() < 2 || !random.nextBoolean()){
            return true;
        }

        ComponentType prevType = prevTypes.get(prevTypes.size()-2);
        return prevType == ComponentType.LADDER;
    }

    @Override
    public String toString() {
        return componentMap.stream()
                .map(list -> list.stream().map(ComponentType::getShape).collect(toList()))
                .map(list -> String.join("", list).concat("\n"))
                .reduce("", String::concat);
    }
}
