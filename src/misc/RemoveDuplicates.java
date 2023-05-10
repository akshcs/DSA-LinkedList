package misc;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(Objects.isNull(head)){
            return null;
        }
        Set<Integer> entry = new HashSet<>();
        pushToSet(entry, head.val);
        ListNode prev, curr;
        prev = curr = head;
        removeDuplicates(prev, curr, entry);
        return head;
    }

    public static void removeDuplicates(ListNode prev, ListNode curr, Set<Integer> entry){
        while(!Objects.isNull(curr)){
            if(Objects.nonNull(curr.next)){
                curr = getNext(curr);
                if(!pushToSet(entry, curr.val)){
                    prev.next = getNext(curr);
                }else{
                    prev = curr;
                }
            }
            else{
                curr = null;
            }
        }
    }

    public static boolean pushToSet(Set<Integer> entry, int elem){
        if(entry.contains(elem)){
            return false;
        }
        entry.add(elem);
        return true;
    }

    public static ListNode getNext(ListNode head){
        if(Objects.nonNull(head.next)){
            return head.next;
        }
        return null;
    }

    public static ListNode insertDuplicates(ListNode duplicateList) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node1.next = node4;
        node4.next = node6;
        node6.next = duplicateList;
        return node1;
    }

    public static boolean checkDuplicates(ListNode head){
        Set<Integer> values = new HashSet<>();
        while(Objects.nonNull(head)){
            if(!pushToSet(values, head.val)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
