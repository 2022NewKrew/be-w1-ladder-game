package ladder.domain;

import java.util.stream.Stream;

import static ladder.LadderMain.MAX_LENGTH;

public enum Shape {
    COL("|"),
    ROW("-"),
    BLANK_ROW(" ");

    private final String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        if(shape.equals("|")) return shape;
        return Stream.generate(() -> shape).limit(MAX_LENGTH).reduce((a, b) -> a + b).get();
    }
}
