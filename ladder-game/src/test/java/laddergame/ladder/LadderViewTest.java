package laddergame.ladder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LadderViewTest {
    static Ladder ld = new Ladder("pobi,honux,crong,jk",5);
    static Scanner sc = new Scanner(System.in);
    ArrayList<String> participantList;

    @BeforeEach
    void setUp(){
        participantList = ld.getParticipantList();
    }

    @AfterEach
    void tearDown(){

    }


    @Test
    void participantInputUI() {
        for (int i=0;i<participantList.size();i++){
            assertTrue(participantList.get(i).length()<=5);
        }
    }
}