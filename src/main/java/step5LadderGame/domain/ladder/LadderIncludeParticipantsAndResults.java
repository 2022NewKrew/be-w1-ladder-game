package step5LadderGame.domain.ladder;

import step2LadderGame.domain.ladder.Branch;
import step3LadderGame.domain.ladder.LadderIncludeParticipants;

import java.util.*;

public class LadderIncludeParticipantsAndResults extends LadderIncludeParticipants {

    private final List<String> results = new ArrayList<>();

    private final Map<String, String> matchingResults = new Hashtable<>();

    public List<String> getResults() {
        return results;
    }

    public Optional<String> getMatchingResult(String participants) {
        return Optional.of(matchingResults.get(participants));
    }

    protected LadderIncludeParticipantsAndResults(List<Branch> branches, List<String> participants, List<String> results) {
        super(branches, participants);
        addAllResults(results);
        trace();
    }

    private void trace() {
        //TODO 구현 필요
        final int[] dx = {1, -1, 0};
        final Queue<Node> q = new LinkedList<>();

        final List<String> participants = getParticipants();

        initStartNode(q, participants);

        while (!q.isEmpty()) {
            final Node cur = q.poll();

            boolean isHeightExceeded = cur.y == getHeight();
            if (isHeightExceeded) {
                final String participant = participants.get(cur.id);
                final String result = results.get(cur.x / 2);

                matchingResults.put(participant, result);
                continue;
            }

            // 오 왼 밑
            for (int i = 0; i < 3; ++i) {
                final Node next = new Node(cur);
                next.x += dx[i];

                if (isBoundsExceeded(next))
                    continue;

                if (isDisconnect(next))
                    continue;

                goToNextIndex(next, dx, i);
                q.add(next);
                break;
            }
        }
    }

    private void initStartNode(Queue<Node> q, List<String> participants) {
        for (int i = 0; i < participants.size(); i++) {
            q.add(new Node(i, 0, i * 2));
        }
    }

    private void goToNextIndex(Node next, int[] dx, int i) {
        next.y++;
        if (i != 2) {
            next.x += dx[i];
        }
    }

    private boolean isDisconnect(Node next) {
        return branches.get(next.y).isDisConnected(next.x);
    }

    private boolean isBoundsExceeded(Node next) {
        return (next.x < 0 || next.x >= getWidth());
    }

    private void addAllResults(List<String> results) {
        this.results.addAll(results);
    }

    private static class Node {
        int id;
        int y;
        int x;

        public Node(int id, int y, int x) {
            this.id = id;
            this.y = y;
            this.x = x;
        }

        public Node(Node node) {
            this.id = node.id;
            this.y = node.y;
            this.x = node.x;
        }
    }
}
