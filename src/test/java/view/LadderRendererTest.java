package view;

import controller.LadderController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.Ladder;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LadderRendererTest {

    @Test
    public void paddingNameTest(){
        LadderRenderer ladderRenderer = new LadderRenderer();
        try{
            Method method = LadderRenderer.class.getDeclaredMethod("paddingStrings", String.class);
            method.setAccessible(true);
            String target = "abc";
            String expected = " abc ";
            Assertions.assertEquals(expected, method.invoke(new LadderRenderer(), target));
            target = "aa";
            expected = "  aa ";
            Assertions.assertEquals(expected, method.invoke(new LadderRenderer(), target));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}