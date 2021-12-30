package domain.ladder;

import java.util.List;

public class Ladder {

    private final int peopleCount;
    private final int height;
    private List<Line> ladderShape;

    protected Ladder(Builder builder) {
        this.peopleCount = builder.peopleCount;
        this.height = builder.height;
        this.ladderShape = builder.ladderShape;
    }

    // 빌더 패턴 적용
    public static class Builder{
        // Ladder와 동일한 필드
        private int peopleCount;
        private int height;
        private List<Line> ladderShape;

        // 필드별 Setter
        public Builder peopleCount(int peopleCount){
            // validate
            this.peopleCount = peopleCount;
            if (this.peopleCount < 1) throw new IllegalArgumentException("1명 이상의 인원 수를 입력하세요.");
            return this;
        }

        public Builder height(int height){
            // validate
            this.height = height;
            if (this.height < 1) throw new IllegalArgumentException("1 이상의 높이를 입력하세요.");
            return this;
        }

        public Builder ladderShape(List<Line> ladderShape){
            this.ladderShape = ladderShape;
            return this;
        }

        // Ladder를 반환하는 메서드
        public Ladder build(){
            return new Ladder(this);
        }


    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLadderShape() {
        return ladderShape;
    }

    public void setLadderShape(List<Line> ladderShape) {
        this.ladderShape = ladderShape;
    }
}
