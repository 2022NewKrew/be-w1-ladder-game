package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> isLinkLists = new ArrayList<>();

    public Line() {
    }

    public void setAbleLink(boolean isLink) {
        this.isLinkLists.add(isLink);
    }

    public List<Boolean> getIsLinkLists() {
        return this.isLinkLists;
    }
}
