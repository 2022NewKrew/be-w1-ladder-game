package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameSimulator {
    private static final int START_HEIGHT = 0;

    static class Point {
        private static final int MOVING_UNIT = 1;

        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        private int getRow() {
            return row;
        }

        private int getCol() {
            return col;
        }

        private void moveLeft() {
            row -= MOVING_UNIT;
        }

        private void moveRight() {
            row += MOVING_UNIT;
        }

        private void moveDown() {
            col += MOVING_UNIT;
        }

        private boolean isNotFinished(int endHeight) {
            return col != endHeight;
        }
    }

    private final Ladder ladder;

    public GameSimulator(Ladder ladder) {
        this.ladder = ladder;
    }

    public Map<String, String> getLadderResultMap(List<String> userList, List<String> resultList) {
        return userList.stream()
                .collect(Collectors.toMap(
                        user -> user,
                        user -> resultList.get(getResultOf(userList.indexOf(user))))
                );
    }

    private int getResultOf(int rowIndex) {
        Point point = new Point(rowIndex, START_HEIGHT);

        while (point.isNotFinished(ladder.getLadderHeight())) {
            move(point);
        }

        return point.getRow();
    }

    private void move(Point point) {
        int row = point.getRow();
        int col = point.getCol();

        if (ladder.isPossibleMovingLeft(row, col)) {
            point.moveLeft();
        } else if (ladder.isPossibleMovingRight(row, col)) {
            point.moveRight();
        }

        point.moveDown();
    }
}
