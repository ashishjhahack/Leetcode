/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return divide(lists, 0, lists.length-1);
    }
    private ListNode divide(ListNode[] lists, int left, int right){
        if (left > right) return null;
        // means this is the last remaining
        if(left == right){
            return lists[left];
        }
        // Divide the range into two halves
        int mid = left + (right-left)/2;

        // Conquer: merge lists in each half
        ListNode first = divide(lists, left, mid);
        ListNode second = divide(lists, mid+1, right);

        // Combine: merge the two sorted lists
        return mergeSortedList(first, second);
    }
    private ListNode mergeSortedList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;

        return dummy.next;
    }
}