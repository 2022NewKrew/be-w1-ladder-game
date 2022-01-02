package com.meg.laddergame.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getBridgeWhenExistBridge() {
        Line line1 = new Line();
        line1.getpoints().add(true);
        assertNotEquals(true, line1.getBridge(1));
    }
}