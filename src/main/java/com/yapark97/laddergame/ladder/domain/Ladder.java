package com.yapark97.laddergame.ladder.domain;

import com.yapark97.laddergame.ladder.domain.row.LadderRow;
import com.yapark97.laddergame.ladder.domain.row.ResultsRow;
import com.yapark97.laddergame.ladder.domain.row.Row;
import com.yapark97.laddergame.ladder.domain.row.ParticipantsRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    private final int maxHeight;
    private final List<Row> rows;
    private final Map<String, Integer> participants;
    private final Map<Integer, String> results;

    public Ladder(List<String> participants, int maxHeight, List<String> results) {
        this.maxHeight = maxHeight;

        rows = new ArrayList<>();
        this.participants = new HashMap<>(participants.size());
        this.results = new HashMap<>(results.size());
        initLadder(participants, results);
    }

    private void initLadder(List<String> participants, List<String> results) {
        rows.add(new ParticipantsRow(participants));
        for (int i=0; i<maxHeight; i++) {
            rows.add(new LadderRow(participants.size()));
        }
        rows.add(new ResultsRow(results));
        for (int i=0; i<participants.size(); i++) {
            this.participants.put(participants.get(i), i);
            this.results.put(i, results.get(i));
        }
    }

    public String getSimpleOutput(final int WIDTH) {
        return rows.stream()
                    .map(row -> row.getSimpleOutput(WIDTH))
                    .collect(Collectors.joining("\n"));
    }

    public List<String> getParticipants() {
        return new ArrayList<>(participants.keySet());
    }

    public String getResult(String participant) {
        int index = participants.get(participant);

        for (Row row: rows) {
            index = row.move(index);
        }
        return results.get(index);
    }
}
