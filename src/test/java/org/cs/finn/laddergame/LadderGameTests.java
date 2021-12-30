package org.cs.finn.laddergame;

import org.assertj.core.api.Assertions;
import org.cs.finn.laddergame.domain.Ladder;
import org.cs.finn.laddergame.domain.Member;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LadderGameTests {
    private final SecureRandom secureRandom = new SecureRandom();

    @Test
    @DisplayName("Test 모듈 작동 확인")
    public void basicTest() {
        Assertions.assertThat(2 + 3)
                .isEqualTo(5);
        Assertions.assertThat(List.of(1, 2))
                .isNotEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("LadderHeight 객체 검사")
    public void testLadderHeight() {
        // given
        final int value = 10;
        final LadderHeight ladderHeight = new LadderHeight(String.valueOf(value));

        // then
        Assertions.assertThatThrownBy(() -> new LadderHeight(null))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new LadderHeight("test"))
                .isInstanceOf(NumberFormatException.class);
        Assertions.assertThatThrownBy(() -> new LadderHeight("100"))
                .isInstanceOf(IndexOutOfBoundsException.class);

        Assertions.assertThat(ladderHeight.getLadderHeight())
                .isEqualTo(value);
    }

    @Test
    @DisplayName("Member 객체 검사")
    public void testMember() {
        // given
        final List<String> normal = new ArrayList<>(Member.DEFAULT_MEMBER);
        final Member memberNormal = new Member(String.join(Member.SEPARATOR, normal));

        final List<String> digit = List.of("1", "12", "123", "1234", "12345", "123456");
        final List<String> digitExpected = List.of("1", "12", "123", "1234", "12345");
        final Member memberDigit = new Member(String.join(Member.SEPARATOR, digit));

        final List<String> alphaNum = List.of("a1", "1d2", "1c", "lbvi2", "12jik", "kdjflkjel");
        final List<String> alphaNumExpected = List.of("a1", "1d2", "1c", "lbvi2", "12jik");
        final Member memberAlphaNum = new Member(String.join(Member.SEPARATOR, alphaNum));

        final List<String> unicode = List.of("1", "2", "사과", "배", "귤1감자", ";-=~", "非正常文字", "바 ij");
        final List<String> unicodeExpected = List.of("1", "2");
        final Member memberUnicode = new Member(String.join(Member.SEPARATOR, unicode));

        final List<String> exceed = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        // then
        Assertions.assertThatThrownBy(() -> new Member(null))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Member(String.join(Member.SEPARATOR, exceed)))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThat(memberNormal.getMemberList())
                .isEqualTo(normal);
        Assertions.assertThat(memberDigit.getMemberList())
                .isEqualTo(digitExpected);
        Assertions.assertThat(memberAlphaNum.getMemberList())
                .isEqualTo(alphaNumExpected);
        Assertions.assertThat(memberUnicode.getMemberList())
                .isEqualTo(unicodeExpected);
    }

    @Test
    @DisplayName("Ladder 객체 검사")
    @SuppressWarnings("all")
    public void testLadder() {
        // given
        final LadderHeight ladderHeight = LadderHeight.getDefault();
        final Member member = Member.getDefault();
        final Ladder ladder = new Ladder(secureRandom, ladderHeight, member);
        // when

        // then
        Assertions.assertThatThrownBy(() -> new Ladder(null, ladderHeight, member))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Ladder(secureRandom, null, member))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Ladder(secureRandom, ladderHeight, null))
                .isInstanceOf(RuntimeException.class);

        Assertions.assertThat(
                ladder.getLadderRows()
                        .getLadderRowList()
                        .size()
                ).isEqualTo(LadderHeight.INIT);
        Assertions.assertThat(
                ladder.getLadderRows()
                        .getLadderRowList()
                        .get(0)
                        .getBridgeList()
                        .size()
                ).isEqualTo(Member.INIT - 1);
    }
}
