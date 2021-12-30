package domain.ladder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class LadderWithName extends Ladder{

    // 이름 목록
    private final List<String> names;

    // 이름과 순서를 매핑
    private Map<String, Integer> nameToNumMap;

    protected LadderWithName(Builder builder) {
        super(builder);
        this.names = builder.names;
        this.nameToNumMap = builder.nameToNumMap;
        // 순서(사다리 번호)를 따로 지정하지 않으면 입력 순서대로 생성 - (요구사항에 없는 추가 구현)
        if (builder.nameToNumMap == null) {
            this.nameToNumMap = new ConcurrentHashMap<>();
            // Map<name - 사다리 번호>
            IntStream.range(0, names.size()).forEach(i -> nameToNumMap.put(names.get(i), i));
        }
    }

    public static class Builder extends Ladder.Builder{
        private List<String> names;
        private Map<String, Integer> nameToNumMap;

        public Builder names(List<String> names){
            names.stream()
                    .forEach(name -> {if(name.length() < 1 || name.length() > 5) throw  new IllegalArgumentException("이름은 최소 1글자 최대 5글자를 입력할 수 있습니다.");});

            this.names = names;
            return this;
        }

        public Builder nameToNumMap(Map<String, Integer> nameToNumMap){
            this.nameToNumMap = nameToNumMap;
            return this;
        }

        public LadderWithName build(){
            return new LadderWithName(this);
        }

    }

    public List<String> getNames() {
        return names;
    }

    public Map<String, Integer> getNameToNumMap() {
        return nameToNumMap;
    }
}
