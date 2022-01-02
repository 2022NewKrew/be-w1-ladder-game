package domain.sadari;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SadariMapTest {

    SadariMap sadariMap;

    @BeforeEach
    void setUp() {
        sadariMap = new SadariMap(5, 5);
    }

    @Test
    void 사다리_선이_인접한_경우() {
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_LINE);
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_BORDER);
        assertFalse(sadariMap.isNotExistPreviousSadariLine(0, 3));
    }

    @Test
    void 사다리_선이_인접하지_않은_경우() {
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.EMPTY);
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_BORDER);
        assertTrue(sadariMap.isNotExistPreviousSadariLine(0, 3));
    }

    @Test
    void 첫번째_사다리선을_놓을때는_인접한_선이_무조건_없다() {
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_BORDER);
        assertTrue(sadariMap.isNotExistPreviousSadariLine(0, 1));
    }

    @Test
    void 각행의_짝수번쨰는_사다리경계이다() {
        assertTrue(sadariMap.isBorder(0));
        assertTrue(sadariMap.isBorder(2));
    }

    @Test
    void 각행의_홀수번쨰는_사다리경계가_아니다() {
        assertFalse(sadariMap.isBorder(1));
        assertFalse(sadariMap.isBorder(3));
    }

}