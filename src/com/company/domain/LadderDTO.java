package com.company.domain;

import java.util.List;

public class LadderDTO {
    private final List<String> names;
    private final List<String> ladderInfo;

    public LadderDTO(List<String> names, List<String> ladderInfo) {
        this.names = names;
        this.ladderInfo = ladderInfo;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getLadderInfo() {
        return ladderInfo;
    }
}

