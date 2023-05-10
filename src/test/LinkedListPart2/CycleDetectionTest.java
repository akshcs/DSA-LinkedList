package test.LinkedListPart2;

import LinkedListPart2.CycleDetection;
import LinkedListPart2.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CycleDetectionTest {

    private ListNode cycleList;
    private ListNode noCycleList;
    @BeforeEach
    public void setUp(){
        noCycleList = ListNode.createListNode(6);
        cycleList = ListNode.createListNode(7);
        CycleDetection.createCycle(5, 3, cycleList);
    }
    @Test
    public void detectCycle_NoCycle(){
        assertFalse(CycleDetection.detectCycle(noCycleList));
    }

    @Test
    public void detectCycle_Cycle(){
        assertTrue(CycleDetection.detectCycle(cycleList));
    }
}
