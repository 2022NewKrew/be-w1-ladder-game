package org.cs.finn.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MemberTests {

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
}
