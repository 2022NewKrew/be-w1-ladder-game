package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Layer> layers;
    private final List<String> participants;
    private final List<String> results;
    private final Map<String, String> resultMap;

    public Ladder(List<String> participants, List<String> results, List<Layer> layers) {
        this.participants = Collections.unmodifiableList(participants);
        this.results = Collections.unmodifiableList(results);
        this.layers = Collections.unmodifiableList(layers);
        this.resultMap = new HashMap<>();
    }

    public List<Layer> getLayers () {
        return layers;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }

    public String getSingleResult(String query) {
        if (resultMap.containsKey(query)) {
            return resultMap.get(query);
        }

        return "해당 참가자가 존재하지 않습니다.";
    }

    public String getEveryResults() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : resultMap.keySet()){
            stringBuilder.append(key);
            stringBuilder.append(": ");
            stringBuilder.append(resultMap.get(key));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public void buildResultMap() {
        List<Integer> participantIndices = IntStream.range(0, this.participants.size())
                .boxed()
                .collect(Collectors.toList());

        for (Layer layer : this.layers) {
            layer.proceed(participantIndices);
        }

        for (int resultIndex = 0 ; resultIndex < participantIndices.size() ; resultIndex++) {
            int participantIndex = participantIndices.get(resultIndex);
            this.assignResult(participantIndex, resultIndex);
        }
    }

    private void assignResult(int participantIndex, int resultIndex) {
        try{
            this.resultMap.put(this.participants.get(participantIndex), this.results.get(resultIndex));
        } catch (IndexOutOfBoundsException exception) {
            this.resultMap.put(this.participants.get(participantIndex), "");
        }
    }

}
