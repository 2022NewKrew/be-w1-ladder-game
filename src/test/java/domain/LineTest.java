package domain;

import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    public void printFiveLetters() {
        Line line = new Line(10);
        line.printLine(4);
    }
}