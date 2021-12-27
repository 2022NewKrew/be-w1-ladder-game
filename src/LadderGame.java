public class LadderGame {
    private final int numberOfPeople;
    private final int height;
    private char[][] cells;

    public LadderGame(int numberOfPeople, int height) {
        this.numberOfPeople = numberOfPeople;
        this.height = height;
        setCells();
    }

    /**
     * 사다리 상태를 세팅한다.
     */
    private void setCells() {
        this.cells = new char[height][numberOfPeople * 2 - 1];
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                this.cells[i][j] = j % 2 == 0 ? '|' : getRandomCell();
            }
        }
    }

    /**
     * 0 ~ 1 사이의 난수를 생성하여, 0 이라면 ' '(공백)을 반환하고, 1 이라면 '-'을 반환한다.
     */
    private char getRandomCell() {
        return (int) (Math.random() * 2) % 2 == 0 ? ' ' : '-';
    }

    /**
     * 사다리 상태를 반환한다.
     */
    public String getLadderStatus() {
        StringBuilder gameStatus = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                gameStatus.append(cells[i][j]);
            }
            gameStatus.append("\n");
        }
        return gameStatus.toString();
    }
}
