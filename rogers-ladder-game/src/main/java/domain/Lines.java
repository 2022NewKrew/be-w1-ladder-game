package domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lines {
    static final String WIDTH_LENGTH_EXCEPTION_MESSAGE = "사다리의 넓이는 양수여야합니다.";
    static final String HEIGHT_LENGTH_EXCEPTION_MESSAGE = "사다리의 높이는 양수여야합니다.";

    private static final String BLANK_SPACE = "    ";

    private final List<Line> lines;

    public Lines(int width, int height){
        validate(width, height);
        this.lines = createLines(width, height);
    }

    private static void validate(int width, int height){
        if(width <= 0){
            throw new IllegalArgumentException(WIDTH_LENGTH_EXCEPTION_MESSAGE);
        }

        if(height <= 0){
            throw new IllegalArgumentException(HEIGHT_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static List<Line> createLines(int width, int height){
        return Stream
                .generate(()->new Line(width))
                .limit(height)
                .collect(toList());
    }

    @Override
    public String toString(){
        return lines.stream()
                .map(line -> BLANK_SPACE.concat(line.toString().concat("\n")))
                .reduce("", String::concat);
    }
}
