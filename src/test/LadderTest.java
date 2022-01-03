package test;

import com.company.domain.Ladder;
import com.company.domain.LadderDTO;
import com.company.view.LadderView;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderTest {
    public Ladder createTestLadder(int n, int height) {
        String[] names = new String[n];
        String[] results = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = String.valueOf(i);
            results[i] = String.valueOf(i);
        }
        return new Ladder(names, results, height);
    }

    @Test
    public void 이름_5글자_확인() {
        String[] names = {"123456", "1234567", "12345678"};
        String[] results = {"x", "o", "x"};
        Ladder ladder = new Ladder(names, results, 5);
        LadderView ladderView = ladder.getLadderView();

        ladderView.getNameView().forEach(s -> Assert.assertTrue("ladderView의 공백을 포함한 nameView가 5글자를 초과합니다.", s.length() <= 5));
    }

    @Test
    public void 사다리줄_겹침_확인_반복() {
        for (int i = 0; i < 1000; i++) {
            사다리줄_겹침_확인(createTestLadder(100, 100));
        }
    }


    public void 사다리줄_겹침_확인(Ladder paramLadder) {
        Ladder ladder = paramLadder;
        LadderDTO ladderDTO = ladder.getLadderDTO();
        for (String line : ladderDTO.getLadderInfo()) {
            checkLine(line);
        }
    }


    public void checkLine(String line) {
        for (int i = 1; i < line.length(); i++) {
            Assert.assertFalse(line.charAt(i - 1) == '-' && line.charAt(i) == '-');
        }
    }

    @Test
    public void 사다리_결과_정상매핑_확인_반복() {
        for (int i = 0; i < 1000; i++) 사다리_결과_정상매핑_확인();
    }

    public void 사다리_결과_정상매핑_확인() {
        Ladder ladder = createTestLadder(100, 100);
        LadderDTO ladderDTO = ladder.getLadderDTO();
        List<String> names = new ArrayList<String>(ladderDTO.getNames());
        List<String> results = new ArrayList<String>(ladderDTO.getResults());
        Map<String, String> resultFromName = ladderDTO.getResultFromName();

        for (String name : names) {
            String result = resultFromName.get(name);
            Assert.assertNotNull("결과가 null입니다.", result);
            Assert.assertTrue("결과가 중복됩니다.", results.remove(result));
        }
    }
}