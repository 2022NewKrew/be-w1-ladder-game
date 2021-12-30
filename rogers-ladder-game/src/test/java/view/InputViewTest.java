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
    private static final int height = 5;

    @Test
    public void testFailedWhenWrongFormat(){
        //given
        InputStream inputStream = makeInput(names, height, " ");

        //when
        Optional<InputDto> inputDtoOptional = InputView.input(new Scanner(inputStream));

        //then
        assertTrue(inputDtoOptional.isEmpty());
    }

    @Test
    public void testSuccessWhenRightFormat(){
        //given
        InputStream inputStream = makeInput(names, height, ",");

        //when
        InputDto inputDto = InputView.input(new Scanner(inputStream)).orElseThrow();

        //then
        assertEquals(names.size(), inputDto.getNames().size());
        assertEquals(height, inputDto.getHeight());
    }

    private static InputStream makeInput(List<String> names, int height, String nameSeparator){
        String inputString = names.stream()
                .reduce((name1, name2) -> name1.concat(nameSeparator).concat(name2))
                .get()
                .concat("\n")
                .concat(Integer.toString(height));

        return convertToStream(inputString);
    }

    private static InputStream convertToStream(String string){
        return new ByteArrayInputStream(string.getBytes());
    }
}