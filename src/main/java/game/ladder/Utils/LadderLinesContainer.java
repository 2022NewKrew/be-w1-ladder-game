package game.ladder.Utils;

import game.ladder.LadderLine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LadderLinesContainer implements Iterable<LadderLine> {
    private final ArrayList<LadderLine> ladderLineArrayList;

    public LadderLinesContainer(Collection<? extends LadderLine> ladderLineList) {
        this.ladderLineArrayList = new ArrayList<>(ladderLineList.size());
        this.ladderLineArrayList.addAll(ladderLineList);
    }
    public int size(){
        return ladderLineArrayList.size();
    }

    public LadderLine get(int i){
        return ladderLineArrayList.get(i);
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return ladderLineArrayList.iterator();
    }

    @Override
    public void forEach(Consumer<? super LadderLine> action) {
        ladderLineArrayList.forEach(action);
    }

    @Override
    public Spliterator<LadderLine> spliterator() {
        return ladderLineArrayList.spliterator();
    }
}
