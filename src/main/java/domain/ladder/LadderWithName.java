package domain.ladder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class LadderWithName extends Ladder{

    private final List<String> names;

    private Map<String, Integer> nameToNumMap;

    protected LadderWithName(Builder builder) {
        super(builder);
        this.names = builder.names;
        this.nameToNumMap = builder.nameToNumMap;
        if (builder.nameToNumMap == null) {
            this.nameToNumMap = new ConcurrentHashMap<>();
            // name - 사다리 숫자 Map
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
