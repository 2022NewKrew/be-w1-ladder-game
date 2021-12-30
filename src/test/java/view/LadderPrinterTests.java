package view;

import model.Ladder;
import model.Player;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderPrinterTests {
    static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    static OutputStream sysOutBackup = System.out;
    static OutputStream sysErrBackup = System.err;

    static int numParticipant;
    static int height;
    static List<Player> players;
    static Ladder ladder;

    @BeforeAll
    static void beforeAll(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        numParticipant = 8;
        height = 8;
        players = new ArrayList<Player>(){{
            add(new Player("kina"));
            add(new Player("ica"));
            add(new Player("creed"));
            add(new Player("roger"));
            add(new Player("pug"));
            add(new Player("theo"));
            add(new Player("ben"));
            add(new Player("jake"));
        }};

        ladder = new Ladder(numParticipant, height, players);
    }

    @AfterAll
    static void afterAll(){

    }

    @Test
    void printPlayerTest(){

        LadderPrinter ladderPrinter = LadderPrinter.getInstance();

        StringBuilder sb = new StringBuilder();
        //printPlayer
        try {
            Method method = ladderPrinter.getClass().getDeclaredMethod(
                    "printPlayer",
                    StringBuilder.class,
                    List.class
            );

            method.setAccessible(true);
            method.invoke(ladderPrinter, sb, players);
            System.out.print(sb.toString().length());
            assertTrue(sb.toString().length() >= 5 * numParticipant);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
