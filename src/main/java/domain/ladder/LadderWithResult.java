package domain.ladder;

import java.util.List;

public class LadderWithResult extends LadderWithName{

    // 각 실행 결과 목록
    private final List<String> results;

    private LadderWithResult(Builder builder){
        super(builder);
        this.results = builder.results;
    }

    public static class Builder extends LadderWithName.Builder{
        private List<String> results;

        public Builder results(List<String> results){
            results.stream()
                    .forEach(name -> {if(name.length() < 1 || name.length() > 5) throw  new IllegalArgumentException("결과는 최소 1글자 최대 5글자를 입력할 수 있습니다.");});
            this.results = results;
            return this;
        }

        public LadderWithResult build() {
            return new LadderWithResult(this);
        }
    }

    public List<String> getResults() {
        return results;
    }
}
