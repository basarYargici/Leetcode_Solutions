package LinkedLists;

import java.awt.*;

/**
 * Project: Leetcode
 * Package: LinkedLists
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 22.01.2021
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {


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

    /**
     * Reversing given linked list in iteratively way
     *
     * @param head is the starting node of linked list
     * @return head of reversed list
     */
    public ListNode reverseList(ListNode head) {
        int size = 0;
        // temp will be iterator on list
        ListNode temp = head;

        // get size of list
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // taking iterator to start of list
        temp = head;

        // if list has only one node, reversed list will be the same
        if (size == 1) {
            return head;
        }

        // array to copy all node values
        int[] tempArr = new int[size];

        // copy process on array
        int i = 0;
        while (temp != null) {
            tempArr[i] = temp.val;
            temp = temp.next;
            i++;
        }

        // dummy node to know tail of list
        ListNode dummyNode = new ListNode(0);
        temp = dummyNode;

        // creating new list from reversed array
        for (int j = size - 1; 0 <= j; j--) {
            ListNode newNode = new ListNode(tempArr[j], dummyNode);

            // if temp and dummy node are shows the same node, it means list is empty
            // and new node will be the head of list
            if (temp == dummyNode) {
                head = newNode;
            } else {
                temp.next = newNode;
            }
            temp = newNode;
        }

        // delete the dummy node
        temp.next = null;

        return head;
    }

}
