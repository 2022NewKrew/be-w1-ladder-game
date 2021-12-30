package com.company.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderDTO {
    private final int NUM_PEOPLE;
    private final int HEIGHT;

    private List<String> names;
    private List<String> ladderInfo;

    public LadderDTO(List<String> names, List<String> ladderInfo) {
        this.names = names;
        this.ladderInfo = ladderInfo;
        this.NUM_PEOPLE = names.size();
        this.HEIGHT = ladderInfo.size();
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getLadderInfo() {
        return ladderInfo;
    }
}

