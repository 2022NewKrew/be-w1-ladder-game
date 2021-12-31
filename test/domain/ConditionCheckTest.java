package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConditionCheckTest {

    @DisplayName("사다리 참여자,결과 최대 5글자를 넘지 않는가?")
    @Test
    void 사다리_참여자_결과_글자수_확인() {

        //given
        List<String> participants = Arrays.asList("pobi","honux","crong","jk","jeff","binary","clo","keith","hoody","champ","aaaaaa","aas","fdsw","adfe","fdsafg","gdsagsdagsda","asdf","sdfsa","sdf","fewr","qwer","fdvv","fffffa","ssdffs","adsffgg","qwerwer","vcxzv","dsf","w","rqwerfs");

        int cnt = 1000;

        while(cnt-- > 0) {
            int n = (int) (Math.random() * participants.size());
            List<String> list = new ArrayList<>();
            boolean check = true;

            for(int i = 0; i < n; i++) {
                String s = participants.get((int)(Math.random() * participants.size()));
                if(s.length() > 5)
                    check = false;
                list.add(s);
            }

            //when
            boolean result = ConditionCheck.elementLengthCheck(list);
            //then
            assertTrue(check == result);
        }
    }

    @DisplayName("사다리 높이 양의 정수인가?")
    @Test
    void 사다리높이_확인() {
        //given
        List<String> notPositiveInteger = new ArrayList<>();
        List<String> positiveInteger = new ArrayList<>();

        notPositiveInteger.add("1alpha");
        notPositiveInteger.add("-1");
        notPositiveInteger.add("0");
        notPositiveInteger.add("alpha");
        notPositiveInteger.add("alpha123");
        notPositiveInteger.add("1.1123");

        positiveInteger.add("1");
        positiveInteger.add("101");
        positiveInteger.add("02");
        positiveInteger.add("33");
        positiveInteger.add("1234");
        positiveInteger.add("441");

        //when
        for(String num : notPositiveInteger) {
            boolean check = ConditionCheck.isPositiveInteger(num);
            //then
            assertFalse(check);
        }

        //when
        for(String num : positiveInteger) {
            boolean check = ConditionCheck.isPositiveInteger(num);
            //then
            assertTrue(check);
        }
    }
}