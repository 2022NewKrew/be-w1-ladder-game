package view.input.config;

import java.util.List;

public class LadderConfigWithName extends LadderConfig{

    private final List<String> names;

    public LadderConfigWithName(int peopleCount, int height, List<String> names) {
        super(peopleCount, height);
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

}
