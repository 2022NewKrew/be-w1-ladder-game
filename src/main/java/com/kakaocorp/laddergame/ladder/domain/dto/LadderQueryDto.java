package com.kakaocorp.laddergame.ladder.domain.dto;

import java.util.List;

public class LadderQueryDto {

    private final int number;
    private final int height;
    private final List<String> members;
    private final List<String> results;

    public LadderQueryDto(int number, int height, List<String> members, List<String> results) {
        this.number = number;
        this.height = height;
        this.members = members;
        this.results = results;
    }

    public int getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getMembers() {
        return members;
    }

    public List<String> getResults() {
        return results;
    }
}
