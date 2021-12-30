package domain;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<ComponentType> components;

    public Line(int size){
        validate(size);
        this.components = createComponents(size);
    }

    private static void validate(int size){
        if(size <= 0){
            throw new IllegalArgumentException("라인의 길이는 양수여야합니다.");
        }
    }

    private static List<ComponentType> createComponents(int size){
        List<ComponentType> components = new ArrayList<>();

        for(int col=0; col < size; col++){
            components.add(createComponent(components, col));
        }

        return components;
    }

    private static ComponentType createComponent(List<ComponentType> components, int col){
        if(isLine(col)){
            return ComponentType.LINE;
        }

        if(isEmpty(components)) {
            return ComponentType.EMPTY;
        }

        return ComponentType.LADDER;
    }

    private static boolean isLine(int col){
        return col % 2 == 0;
    }

    private static boolean isEmpty(List<ComponentType> components){
        if(components.size() < 2 || !RandomUtil.getRandomBoolean()){
            return true;
        }

        ComponentType prevType = components.get(components.size()-2);
        return prevType == ComponentType.LADDER;
    }

    @Override
    public String toString() {
        return this.components.stream()
                .map(ComponentType::getShape)
                .reduce("", String::concat);
    }
}