package com.gunyoung.one.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeTest {

    @Test
    void 다리_추가() {
        //Given
        Bridge bridge = Bridge.of(false);

        //When
        bridge.addBridge();

        //Then
        assertTrue(bridge.isExist());
    }

    @Test
    void 다리_삭제() {
        //Given
        Bridge bridge = Bridge.of(true);

        //When
        bridge.removeBridge();

        //Then
        assertFalse(bridge.isExist());
    }
}