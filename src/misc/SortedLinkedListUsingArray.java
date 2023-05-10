package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SortedLinkedListUsingArray {
    public static void main(String[] args){
        int[] arr = {4,5,3,2,1,6};
        ListNode head = convertArrayToListNode(arr);
        printListNode(head);
        List<Integer> arrayList = convertListNodetoArrayList(head);
        sortListNode(head, arrayList);
        printListNode(head);
    }

    static void printListNode(ListNode head){
        while(Objects.nonNull(head)){
            System.out.println(head.val);
            head = head.next;
        }
    }

    static ListNode convertArrayToListNode(int[] arr){
        ListNode curr = null;
        ListNode head = null;
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

    static List<Integer> convertListNodetoArrayList(ListNode head){
        List<Integer> dataInArrayList = new ArrayList<>();
        while(Objects.nonNull(head)){
            dataInArrayList.add(head.val);
            head = head.next;
        }
        return dataInArrayList;
    }

    static void sortListNode(ListNode head, List<Integer> dataInArrayList){
        Collections.sort(dataInArrayList);
        for(int val : dataInArrayList){
            head.val = val;
            head = head.next;
        }
    }
}
