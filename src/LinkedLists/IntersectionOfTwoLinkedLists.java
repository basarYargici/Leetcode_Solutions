package LinkedLists;

/**
 * Project: Leetcode
 * Package: LinkedLists
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 19.01.2021
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Each value on each linked list is in the range [1, 10^9].
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Find the node at which the intersection of two singly linked lists begins
     *
     * @param headA node of first singly linked list
     * @param headB node of second singly linked list
     * @return intersection node if there is an intersection, otherwise null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // getting the length of our linked lists
        int lenA = length(headA), lenB = length(headB);

        // moving heads to the same point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // if intersection node founds, returning value will be intersection,otherwise the loop
        // will end with the value of null
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    /**
     * Counts the node count in given linked list
     *
     * @param head is the starting node
     * @return length of linked list
     */
    public int length(ListNode head) {
        int len = 0;

        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
