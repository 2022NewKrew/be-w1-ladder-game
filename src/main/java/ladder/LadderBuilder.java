package ladder;

public class LadderBuilder {

    public LadderBuilder() {
    }

    public static Ladder createLadder(int width, int height) throws IllegalArgumentException{
        if(width < 1) throw new IllegalArgumentException("참여인원이 잘못 입력되었습니다.");
        if(height < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");

        Ladder ladder = new Ladder()
                .width(width)
                .height(height)
                .buildLadder();
        return ladder;
    }
}
