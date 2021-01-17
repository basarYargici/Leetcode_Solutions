package LinkedLists;

/**
 * Project: Leetcode
 * Package: LinkedLists
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 17.01.2021
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 104].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
public class LinkedListCycle {

    /**
     * Given definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * If one node in list has two previous node it means the list has cycle
     *
     * @param head is the starting node of list
     * @return true if list has cycle, otherwise false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;

        /* Tricky solution, but it changes the list
           ListNode temp = head;
           while (temp != null && temp.next != null){
               if (temp.val == 100000) return true;
               temp.val = 100000; // because Node.val <= 10^5
               temp = temp.next;
           }
           return false;
        */
    }

}
