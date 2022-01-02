package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final Random rand = new Random();
    private final List<Boolean> points = new ArrayList<>();
    private static final String VLINE = "|";
    private static final String HLINE = "-----";
    private static final String SPACE = "     ";
    private static final String PADDING = "  ";

    public Line(int numPeople){
        IntStream
                .range(0,numPeople-1)
                .forEach(this::addPoints);
    }
    @Override
    public String toString(){
        return PADDING + VLINE
                + points
                .stream()
                .map(p -> p ? HLINE : SPACE)
                .collect(Collectors.joining(VLINE))
                + VLINE;
    }
    public int size(){
        return points.size();
    }

    private void addPoints(int i){
        if(isNextLadder(i)){
            points.add(false);
            return;
        }
        points.add(rand.nextBoolean());
    }

    private boolean isNextLadder(int i){
        return i==0? false: points.get(i - 1);
    }

    public void makeSwap(List<Integer> resultOrder){
        IntStream.
                range(0,points.size())
                .boxed()
                .forEach(i -> isSwap(i,resultOrder));
    }
    private void isSwap(int point, List<Integer> resultOrder){
        if(points.get(point)){
            Collections.swap(resultOrder, point,point+1);
        }
    }
}
