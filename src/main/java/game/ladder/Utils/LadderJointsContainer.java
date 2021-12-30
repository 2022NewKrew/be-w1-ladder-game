package game.ladder.Utils;

import game.ladder.LadderJoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LadderJointsContainer implements Iterable<LadderJoint> {
    private ArrayList<LadderJoint> ladderJointArrayList;

    public LadderJointsContainer(Collection<? extends LadderJoint> ladderJointList) {
        this.ladderJointArrayList = new ArrayList<>(ladderJointList.size());
        this.ladderJointArrayList.addAll(ladderJointList);
    }

    public LadderJoint get(int i) {
        return ladderJointArrayList.get(i);
    }

    public int size() {
        return ladderJointArrayList.size();
    }

    @Override
    public Iterator<LadderJoint> iterator() {
        return ladderJointArrayList.iterator();
    }

    @Override
    public void forEach(Consumer<? super LadderJoint> action) {
        ladderJointArrayList.forEach(action);
    }

    @Override
    public Spliterator<LadderJoint> spliterator() {
        return ladderJointArrayList.spliterator();
    }
}
