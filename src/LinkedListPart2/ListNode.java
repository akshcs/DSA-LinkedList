package LinkedListPart2;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode head){
        while(Objects.nonNull(head)){
            System.out.print(head);
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode createListNode(int n){
        ListNode listNode = null;
        for(int i=n;i>=1;i--){
            listNode = new ListNode(i, listNode);
        }
        return listNode;
    }

    public static ListNode findNthNode(ListNode head, int n){
        while(n>1){
            n--;
            head=head.next;
        }
        return head;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}