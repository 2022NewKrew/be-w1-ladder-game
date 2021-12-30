package game.ladder.Utils;

import java.util.*;
import java.util.function.Consumer;

/**
 * First Class Collection of ArrayList<String>
 */
public class PlayerNameContainer implements Iterable<String> {

    private final ArrayList<String> playerNameContainer = new ArrayList<>();

    public PlayerNameContainer(Collection<? extends String> names) {
        playerNameContainer.addAll(names);
    }
    public int size() {
        return playerNameContainer.size();
    }
    public int getIndexOfPlayerByName(String name) {
        return playerNameContainer.indexOf(name);
    }
    public String get(int i) {
        return playerNameContainer.get(i);
    }
    @Override
    public Iterator<String> iterator() {
        return playerNameContainer.iterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        playerNameContainer.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return playerNameContainer.spliterator();
    }
}
