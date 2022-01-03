package test;

import com.company.domain.Ladder;
import com.company.domain.LadderDTO;
import com.company.view.LadderView;
import org.junit.Assert;
import org.junit.Test;

public class LadderTest {

    @Test
    public void 이름_5글자_확인() {
        String[] names = {"123456", "1234567", "12345678"};
        Ladder ladder = new Ladder(names, 5);
        LadderDTO ladderDTO = ladder.getLadderDTO();
        LadderView ladderView = ladder.getLadderView();

        ladderDTO.getNames().forEach(s -> Assert.assertTrue("ladderDTO의 name이 5글자를 초과합니다.", s.length() <= 5));
        ladderView.getNameView().forEach(s -> Assert.assertTrue("ladderView의 공백을 포함한 nameView가 5글자를 초과합니다.", s.length() <= 5));
    }

    @Test
    public void 사다리줄_겹침_확인() {
        String[] names = new String[10];
        for (int i = 0; i < 10; i++) {
            names[i] = String.valueOf(i);
        }

        for (int i = 0; i < 1000; i++) {
            Ladder ladder = new Ladder(names, 5);
            LadderDTO ladderDTO = ladder.getLadderDTO();

            for (String line : ladderDTO.getLadderInfo()) {
                checkLine(line);
            }
        }
    }

    public void checkLine(String line) {
        for (int i = 1; i < line.length(); i++) {
            Assert.assertFalse(line.charAt(i - 1) == '-' && line.charAt(i) == '-');
        }
    }
}