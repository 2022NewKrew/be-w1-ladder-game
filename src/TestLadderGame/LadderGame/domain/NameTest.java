package LadderGame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NameTest {

    @DisplayName("이름을 입력 했는가")
    @Test
    void isEmptyName(){
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            new Name("");
        });
        Assertions.assertEquals(e.getMessage(), "이름을 입력해주세요.");
    }

    @DisplayName("이름의 크기가 5보다 작은가")
    @Test
    void isOverSizeName(){
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            new Name("asdf,ggg,rr,teq,zzfasr");
        });
        Assertions.assertEquals(e.getMessage(), "이름 크기는 5을(를) 넘을 수 없습니다.");
    }

    @DisplayName("이름의 크기가 0보다 큰가")
    @Test
    void isBiggerThanZero(){
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            new Name("adf,rr,tt,,dff,gg");
        });
        Assertions.assertEquals(e.getMessage(), "이름 크기는 0보다 커야합니다.");
    }

    @DisplayName("이름의 크기가 0보다 큰가")
    @Test
    void isSplitRight() throws Exception {
        List<String> nameList = new Name("asdf,asdf,gg,hh").getNameList();
        List<String> wantList = new ArrayList<>();
        wantList.add("asdf");
        wantList.add("asdf");
        wantList.add("gg");
        wantList.add("hh");
        Assertions.assertEquals(nameList, wantList);
    }
}