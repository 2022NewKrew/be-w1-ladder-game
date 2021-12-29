package ladderGame.domain.ladderConfig;

import java.util.ArrayList;
import java.util.List;

public class LadderIncludeNamesConfig extends LadderConfig {
    private final List<String> nameList = new ArrayList<>();

    public List<String> getNameList() {
        return nameList;
    }

    public static LadderIncludeNamesConfig of(List<String> nameList, int height) {
        final LadderIncludeNamesConfig ladderConfig = new LadderIncludeNamesConfig(nameList.size(), height);
        ladderConfig.addAllNames(nameList);

        return ladderConfig;
    }

    private LadderIncludeNamesConfig(int numOfPeople, int height) {
        super(numOfPeople, height);
    }

    private void addAllNames(List<String> nameList) {
        this.nameList.addAll(nameList);
    }
}
