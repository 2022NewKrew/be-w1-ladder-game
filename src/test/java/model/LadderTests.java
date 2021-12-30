package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTests {
    static int numParticipant;
    static int height;
    static List<Player> players;
    static Ladder ladder;

    @BeforeAll
    static void beforeAll(){
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

    @Test
    void getConnectionsTest(){
        List<Ladder.Line> connections = ladder.getConnections();
        connections.stream().forEach(Assertions::assertNotNull);
    }

    @Test
    void getPlayersTest(){
        List<Player> actual = ladder.getPlayers();
        List<Player> expected = new ArrayList<Player>(){{
            add(new Player("kina"));
            add(new Player("ica"));
            add(new Player("creed"));
            add(new Player("roger"));
            add(new Player("pug"));
            add(new Player("theo"));
            add(new Player("ben"));
            add(new Player("jake"));
        }};
        assertEquals(expected, actual);
    }
}
