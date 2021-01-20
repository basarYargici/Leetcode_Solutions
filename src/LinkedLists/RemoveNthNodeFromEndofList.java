package LinkedLists;

/**
 * Project: Leetcode
 * Package: LinkedLists
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 20.01.2021
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNodeFromEndofList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //d   0  1 2 3 4
    //dlr

    //d 0 1 2 3 4
    //dl    r

    //d 0 1 2 3 4
    //d     l     r


    //d  1
    //dlr

    //d  0
    //dl  r
    //d l  r

    /**
     * Given the head of a linked list, removes the nth node from the end of the list and return its head
     *
     * @param head is the head of linked list
     * @param n is the nth node from the end of list
     * @return head of new list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode right = dummy;
        ListNode left = dummy;

        for (int i = 0; i <= n; i++) {
            right = right.next;
        }

        while (right != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }

}
