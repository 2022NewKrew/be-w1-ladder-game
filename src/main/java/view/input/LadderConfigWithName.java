package view.input;

import java.util.List;

public class LadderConfigWithName extends LadderConfig{

    private final List<String> names;

    public LadderConfigWithName(int width, int height, List<String> names) {
        super(width, height);
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    // validate? -> 5글자 체크

}
