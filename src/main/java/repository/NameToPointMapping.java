package repository;

import java.util.HashMap;
import java.util.Set;

public class NameToPointMapping {
    private final HashMap<String, Integer> nameToPoint;
    private int sequence;

    public NameToPointMapping() {
        nameToPoint = new HashMap<>();
        sequence = 0;
    }

    public boolean isKey(String name) { return nameToPoint.containsKey(name); }
    public void addName(String name){ nameToPoint.put(name, sequence++); }
    public int getPoint(String name) { return nameToPoint.get(name); }
    public Set<String> getAllName() { return nameToPoint.keySet(); }
}
