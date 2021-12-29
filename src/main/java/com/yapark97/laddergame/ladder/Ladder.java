package com.yapark97.laddergame.ladder;

import com.yapark97.laddergame.ladder.row.LadderRow;
import com.yapark97.laddergame.ladder.row.Row;
import com.yapark97.laddergame.ladder.row.ParticipantsRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final int maxHeight;
    private final List<Row> rows;
    private final Map<String, Integer> participants;

    public Ladder(List<String> participants, int maxHeight) {
        this.maxHeight = maxHeight;

        rows = new ArrayList<>();
        this.participants = new HashMap<>();
        initLadder(participants);

    }

    private void initLadder(List<String> participants) {
        rows.add(new ParticipantsRow(participants));
        for (int i=0; i<maxHeight; i++) {
            rows.add(new LadderRow(participants.size()));
        }
        for (int i=0; i<participants.size(); i++) {
            this.participants.put(participants.get(i), i);
        }
    }

    public void printLadder() {
        for (Row row : rows) {
            row.print();
        }
    }
}
