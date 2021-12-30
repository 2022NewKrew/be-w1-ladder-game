package rubam.step4.input;

import java.util.List;

public class LadderInformDTO {

    private List<String> names;
    private int height;

    public LadderInformDTO() {
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
