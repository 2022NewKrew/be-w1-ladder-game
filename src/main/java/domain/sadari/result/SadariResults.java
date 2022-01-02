package domain.sadari.result;

import domain.sadari.SadariMapStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SadariResults {

    private final List<SadariResult> sadariResults;


    public SadariResults(String[] sadariResultNames) {
        sadariResults = initializeSadariResults(sadariResultNames);
        validateEmptyResults();
    }

    private List<SadariResult> initializeSadariResults(String[] sadariResultNames) {
        return Arrays.stream(sadariResultNames)
                .map(SadariResult::new)
                .filter(SadariResult::isNotEmptyName)
                .collect(Collectors.toUnmodifiableList());
    }
    private void validateEmptyResults() {
        if (sadariResults.isEmpty()) {
            throw new IllegalStateException("실행 결과를 입력하셔야 합니다.");
        }
    }

    public SadariResult getResult(int number) {
        return sadariResults.get(number - 1);
    }

    public void printSadariResults() {
        sadariResults.forEach(SadariResult::print);
        System.out.println();
    }

}
