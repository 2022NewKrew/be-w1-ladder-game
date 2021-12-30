package util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomScannerTests {
    static InputStream sysInBackup = System.in;

    @AfterAll
    static void afterAll(){
        System.out.println("[CustomScanner 테스트 완료]");
        System.setIn(sysInBackup);
    }

    @DisplayName("readBoundedInt 테스트")
    @Test
    void readBoundedIntTest(){
        ByteArrayInputStream in = new ByteArrayInputStream("six".getBytes());
        System.setIn(in);

        CustomScanner customScanner = new CustomScanner();
        int infimum = 4;
        int supremum = 10;

        try {
            Method method = customScanner.getClass().getDeclaredMethod("readBoundedInt", int.class, int.class);
            method.setAccessible(true);
            Integer ret = (Integer) method.invoke(customScanner, infimum, supremum);
            assertEquals(null, ret);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("verifyBoundedInt 테스트")
    @Test
    void verifyBoundedIntTest(){
        CustomScanner customScanner = new CustomScanner();
        int infimum = 4;
        int supremum = 10;
        int value = 0;

        try {
            Method method = customScanner.getClass().getDeclaredMethod("verifyBoundedInt", int.class, int.class, int.class);
            method.setAccessible(true);
            Integer ret = (Integer) method.invoke(customScanner, infimum, supremum, value);
            assertEquals(null, ret);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("readCommaSeperatedString 테스트")
    @Test
    void readCommaSeperatedStringTest(){
        ByteArrayInputStream in = new ByteArrayInputStream("a,a,a,a".getBytes());
        System.setIn(in);
        CustomScanner customScanner = new CustomScanner();
        int numParticipant = 5;
        int maxLength = 5;
        String message = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        try {
            Method method = customScanner.getClass().getDeclaredMethod("readCommaSeperatedString", int.class, int.class, String.class);
            method.setAccessible(true);
            List<String> ret = (List<String>) method.invoke(customScanner, numParticipant, maxLength, message);
            assertEquals(null, ret);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("verifyCommaSeperatedString 테스트")
    @Test
    void verifyCommaSeperatedStringTest(){
        CustomScanner customScanner = new CustomScanner();
        int numParticipant = 5;
        int maxLength = 5;
        String[] strings = {"a", "aa", "aaaaaa", "aaa", "aaaa"};
        try {
            Method method = customScanner.getClass().getDeclaredMethod("verifyCommaSeperatedString", int.class, int.class, String[].class);
            method.setAccessible(true);
            List<String> ret = (List<String>) method.invoke(customScanner, numParticipant, maxLength, strings);
            assertEquals(null, ret);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
