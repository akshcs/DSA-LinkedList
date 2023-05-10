package test.LinkedListPart2;

import LinkedListPart2.CycleDetection;
import LinkedListPart2.CycleDetection2;
import LinkedListPart2.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CycleDetectionTest2 {

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
        assertNull(CycleDetection2.findCycle(noCycleList));
    }

    @Test
    public void detectCycle_Cycle(){
        assertEquals(ListNode.findNthNode(cycleList, 3), CycleDetection2.findCycle(cycleList));
    }
}
