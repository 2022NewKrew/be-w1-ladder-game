package view;

import dto.InputDto;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private static final List<String> names = List.of("pobi", "honux", "crong", "jk");
    private static final List<String> awards = List.of("꽝", "5000", "꽝", "3000");
    private static final int height = 5;

    @Test
    public void testFailedWhenWrongFormat(){
        //given
        InputStream inputStream = createInputStream(names, awards, height, " ");

        //when
        Optional<InputDto> inputDtoOptional = InputView.input(new Scanner(inputStream));

        //then
        assertTrue(inputDtoOptional.isEmpty());
    }

    @Test
    public void testSuccessWhenRightFormat(){
        //given
        InputStream inputStream = createInputStream(names, awards, height, ",");

        //when
        Optional<InputDto> inputDtoOptional = InputView.input(new Scanner(inputStream));

        //then
        assertTrue(inputDtoOptional.isPresent());
        InputDto inputDto = inputDtoOptional.get();

        assertEquals(names.size(), inputDto.getNames().size());
        assertEquals(height, inputDto.getHeight());
    }

    private static InputStream createInputStream(List<String> names, List<String> awards, int height, String separator){
        String nameStrings = names.stream()
                .reduce((name1, name2) -> name1.concat(separator).concat(name2))
                .orElse("NONE");

        String awardStrings = awards.stream()
                .reduce((award1, award2) -> award1.concat(separator).concat(award2))
                .orElse("NONE");

        String inputString = nameStrings
                .concat("\n")
                .concat(awardStrings)
                .concat("\n")
                .concat(String.valueOf(height));

        return convertToStream(inputString);
    }

    private static InputStream convertToStream(String string){
        return new ByteArrayInputStream(string.getBytes());
    }
}