package org.cs.finn.laddergame.domain.stringvalues;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberTests {

    @Test
    @DisplayName("Member 객체 검사")
    public void testMember() {
        // given
        final List<Member> normalExpected = Members.DEFAULT_MEMBER_LIST;
        final Members memberNormal = Members.getDefault();

        final List<String> digit = List.of("1", "12", "123", "1234", "12345", "123456");
        final List<Member> digitExpected = List.of(new Member("1"), new Member("12"), new Member("123"), new Member("1234"), new Member("12345"));
        final Members memberDigit = new Members(String.join(Members.SEPARATOR, digit));

        final List<String> alphaNum = List.of("a1", "1d2", "1c", "lbvi2", "12jik", "kdjflkjel");
        final List<Member> alphaNumExpected = List.of(new Member("a1"), new Member("1d2"), new Member("1c"), new Member("lbvi2"), new Member("12jik"));
        final Members memberAlphaNum = new Members(String.join(Members.SEPARATOR, alphaNum));

        final List<String> unicode = List.of("1", "2", "사과", "배", "귤1감자", ";-=~", "非正常文字", "바 ij");
        final List<Member> unicodeExpected = List.of(new Member("1"), new Member("2"));
        final Members memberUnicode = new Members(String.join(Members.SEPARATOR, unicode));

        final List<String> exceed = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        // then
        Assertions.assertThatThrownBy(() -> new Members(null))
                .isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Members(String.join(Members.SEPARATOR, exceed)))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThat(memberNormal.getList())
                .isEqualTo(normalExpected);
        Assertions.assertThat(memberDigit.getList())
                .isEqualTo(digitExpected);
        Assertions.assertThat(memberAlphaNum.getList())
                .isEqualTo(alphaNumExpected);
        Assertions.assertThat(memberUnicode.getList())
                .isEqualTo(unicodeExpected);
    }
}
