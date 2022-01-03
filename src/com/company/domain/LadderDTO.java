package com.company.domain;

import java.util.List;
import java.util.Map;

public class LadderDTO {
    private final List<String> names;
    private final List<String> results;
    private final List<String> ladderInfo;
    private final Map<String, String> resultFromName;

    public LadderDTO(List<String> names, List<String> results, List<String> ladderInfo, Map<String, String> resultFromName) {
        this.names = names;
        this.results = results;
        this.ladderInfo = ladderInfo;
        this.resultFromName = resultFromName;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getResults() {
        return results;
    }

    public List<String> getLadderInfo() {
        return ladderInfo;
    }

    public Map<String, String> getResultFromName() {
        return resultFromName;
    }
}

