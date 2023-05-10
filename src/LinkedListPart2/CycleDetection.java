package LinkedListPart2;

import java.util.Objects;

public class CycleDetection {

    public static void createCycle(int sourceIndex, int destIndex, ListNode head){
        if(sourceIndex<destIndex){
            return;
        }
        boolean isCycleCreated = false;
        int currIndex = 1;
        ListNode source = null, dest = null;
        while(!isCycleCreated && !Objects.isNull(head) && !Objects.isNull(head.next)){
            if(currIndex == sourceIndex){
                source = head;
                source.next = dest;
                isCycleCreated = true;
            }
            if(currIndex == destIndex){
                dest = head;
            }
            currIndex++;
            head = head.next;
        }
    }

    public static boolean detectCycle(ListNode head){
        ListNode slow, fast;
        slow = fast = head;
        while(!(Objects.isNull(slow) || Objects.isNull(fast) || Objects.isNull(slow.next) || Objects.isNull(fast.next) || Objects.isNull(fast.next.next))){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
