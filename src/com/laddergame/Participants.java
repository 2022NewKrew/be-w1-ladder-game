package com.laddergame;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    public List<Participant> participants;

    public Participants(String namesString) {
        List<String> names = parseName(namesString);
        participants = names.stream().map(Participant::new).collect(Collectors.toList());
    }

    private List<String> parseName(String namesString) {
        return List.of(namesString.split(PARTICIPANTS_NAME_DELIMITER));
    }

    private static final String PARTICIPANTS_NAME_DELIMITER = ",";
}
