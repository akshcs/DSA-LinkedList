package LinkedListPart2;

import java.util.Objects;

public class CycleDetection2 {
    public static ListNode findCycle(ListNode head) {
        ListNode cycleNode = checkCycle(head);
        if(Objects.isNull(cycleNode)){
            return cycleNode;
        }
        ListNode start = head;
        while(start!=cycleNode){
            start = start.next;
            cycleNode = cycleNode.next;
        }
        return start;
    }

    public static ListNode checkCycle(ListNode head){
        ListNode slow, fast;
        slow = fast = head;
        while(!(Objects.isNull(slow) || Objects.isNull(fast) || Objects.isNull(slow.next) || Objects.isNull(fast.next) || Objects.isNull(fast.next.next))){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return slow;
            }
        }
        return null;
    }
}
