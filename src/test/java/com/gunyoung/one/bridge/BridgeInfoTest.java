package com.gunyoung.one.bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class BridgeInfoTest {

    private BridgeInfo bridgeInfo;
    private BridgeMakeStrategy mockMakeStrategy;

    @BeforeEach
    void setUp() {
        mockMakeStrategy = mock(BridgeMakeStrategy.class);
    }

    @Test
    void 내부다리들_생성() {
        //Given
        BridgeInfo bridgeInfo = getBridgeInfoForTest();

        //When
        bridgeInfo.makeBridges(mockMakeStrategy);

        //Then
        then(mockMakeStrategy).should(times(1)).makeBridges(any());
    }

    private BridgeInfo getBridgeInfoForTest() {
        return getBridgeInfoForTest(10, 10);
    }

    private BridgeInfo getBridgeInfoForTest(int ladderHeight, int maxNumOfBridgesForEachRow) {
        return new BridgeInfo(ladderHeight, maxNumOfBridgesForEachRow, mockMakeStrategy);
    }
}