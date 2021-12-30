package test;

import com.company.domain.Ladder;
import com.company.domain.LadderDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LadderTest {

    @Test
    public void 이름_5글자_확인() {
        String[] names = {"123456", "1234567", "12345678"};
        Ladder ladder = new Ladder(names, 5);
        LadderDTO ladderDTO = ladder.getLadderDTO();

        List<Boolean> nameChecks = ladderDTO.getNames().stream().map(s -> (s.length() <= 5)).collect(Collectors.toList());

        for(Boolean nameCheck : nameChecks) {
            Assert.assertTrue(nameCheck);
        }
    }

    @Test
    public void 사다리줄_겹침_확인() {
        String[] names = new String[10];
        for(int i = 0; i < 10; i++) {
            names[i] = String.valueOf(i);
        }

        for(int i = 0; i < 1000; i++) {
            Ladder ladder = new Ladder(names, 5);
            LadderDTO ladderDTO = ladder.getLadderDTO();

            for (String line : ladderDTO.getLadderInfo()) {
                Assert.assertTrue(checkLine(line));
            }
        }
    }

    public boolean checkLine(String line) {
        for(int i = 1; i < line.length(); i++) {
            if(line.charAt(i-1) == '-' && line.charAt(i) == '-') return false;
        }
        return true;
    }
}