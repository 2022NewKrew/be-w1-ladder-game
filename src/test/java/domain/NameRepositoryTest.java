package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameRepositoryTest {

    @Test
    public void validationCheckTest1(){
        //given
        //유효한 이름 리스트
        List<String> validNameList = Arrays.asList("Ryan", "Muzi", "Prodo");

        //when
        NameRepository nameRepository = new NameRepository(validNameList);

        //then
        assertDoesNotThrow(() -> {
            nameRepository.validationCheck();
        });
    }
    @Test
    public void validationCheckTest2(){
        //given
        //너무 적은 참가자 수를 가진 리스트
        List<String> shortNameList = Arrays.asList("Ryan");

        //when
        NameRepository nameRepository = new NameRepository(shortNameList);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            nameRepository.validationCheck();
        });
    }
    @Test
    public void validationCheckTest3(){
        //given
        //이름이 5글자 이상인 참가자를 포함한 리스트
        List<String> containLongNameList = Arrays.asList("Ryan", "Muzi", "Prodo", "Chunsik");

        //when
        NameRepository nameRepository = new NameRepository(containLongNameList);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            nameRepository.validationCheck();
        });
    }
}