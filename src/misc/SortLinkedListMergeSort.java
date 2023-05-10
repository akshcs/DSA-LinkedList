package misc;
import java.util.Objects;

public class SortLinkedListMergeSort {

    public static void main(String[] args){
        int[] arr = {5,4,3,1,2,6};
        ListNode head = convertArrayToListNode(arr);
        printListNode(head);
        ListNode sortedHead = sortListNode(head);
        printListNode(sortedHead);
    }

    static ListNode convertArrayToListNode(int[] arr){
        ListNode head = null;
        ListNode curr = null;
        for (int j : arr) {
            if (Objects.isNull(curr)) {
                curr = new ListNode(j);
                head = curr;
            } else {
                curr.next = new ListNode(j);
                curr = curr.next;
            }
        }
        return head;
    }

    static void printListNode(ListNode head){
        while(Objects.nonNull(head)){
            System.out.println(head.val);
            head = head.next;
        }
    }

    static ListNode sortListNode(ListNode head){
        if(Objects.isNull(head) || Objects.isNull(head.next)){
            return head;
        }
        ListNode head2 = getMidNode(head);
        ListNode sortedList1 = sortListNode(head);
        ListNode sortedList2 = sortListNode(head2);
        return mergeListNode(sortedList1, sortedList2);
    }

    static ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = slow.next;
        while(Objects.nonNull(fast) && Objects.nonNull(fast.next)){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    static ListNode mergeListNode(ListNode list1, ListNode list2){
        ListNode head = null;
        ListNode curr = null;
        while(Objects.nonNull(list1) && Objects.nonNull(list2)){
            if(list1.val< list2.val){
                if(Objects.isNull(curr)){
                    curr = list1;
                    head = curr;
                } else {
                    curr.next = list1;
                    curr = curr.next;
                }
                list1 = list1.next;
            } else {
                if(Objects.isNull(curr)){
                    curr = list2;
                    head = curr;
                } else {
                    curr.next = list2;
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }
        if(Objects.nonNull(list1)){
            assert curr != null;
            curr.next = list1;
        }
        if(Objects.nonNull(list2)){
            assert curr != null;
            curr.next = list2;
        }
        return head;
    }
}
