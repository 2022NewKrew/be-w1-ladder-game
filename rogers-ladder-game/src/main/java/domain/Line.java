package domain;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<ComponentType> components = new ArrayList<>();

    // static method

    public static Line createLine(int size){
        Line line = new Line();

        for(int col=0; col < size; col++){
            line.addComponent(createComponent(line, col));
        }

        return line;
    }

    private static ComponentType createComponent(Line line, int col){
        if(isLine(col)){
            return ComponentType.LINE;
        }

        if(isEmpty(line)) {
            return ComponentType.EMPTY;
        }

        return ComponentType.LADDER;
    }

    private static boolean isLine(int col){
        return col % 2 == 0;
    }

    private static boolean isEmpty(Line line){
        if(line.getSize() < 2 || !RandomUtil.getRandomBoolean()){
            return true;
        }

        ComponentType prevType = line.getComponent(line.getSize()-2);
        return prevType == ComponentType.LADDER;
    }

    // instance method

    private void addComponent(ComponentType componentType){
        this.components.add(componentType);
    }

    private ComponentType getComponent(int index){
        return this.components.get(index);
    }

    private int getSize(){
        return this.components.size();
    }

    @Override
    public String toString() {
        return this.components.stream()
                .map(ComponentType::getShape)
                .reduce("", String::concat);
    }
}