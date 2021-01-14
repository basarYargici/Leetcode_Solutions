package LinkedLists;

// HAS PROBLEMS

/**
 * Project: Leetcode
 * Package: LinkedLists
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 14.01.2021
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */
class MyLinkedList {

    static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

    private Node head;
    private int size = 0;


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) throws Exception {
        Node node = head;
        int counter = 0;

        if (head == null) {
            throw new Exception("List is empty");
        }
        if (isValidIndex(index)) throw new Exception("invalid index");

        while (counter < index-1) {
            node = node.next;
            counter++;
        }

        return node.data;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            head.next = null;
            size++;
            return;
        }
        Node temp = new Node(val), node = head;
        while (node.hasNext()) {
            node = node.next;
        }
        temp = node.next;
        temp.next = null;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) throws Exception {
        if (isValidIndex(index)) throw new Exception("invalid index");
        if (index == 0) {
            addAtHead(val);
            return;
        } else {
            Node temp, node = head;

            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            temp = node;
            temp.next = node.next;
            node.next = temp;

            temp.data = val;
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) throws Exception {
        if (isValidIndex(index)) throw new Exception("invalid index");
        Node temp, node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        temp = node.next;
        node.next = temp.next;
        size--;
    }

    /**
     * Checks the validation of index
     *
     * @param index is the wanted nodes index
     * @return true if index is valid, otherwise false
     */
    private boolean isValidIndex(int index) {
        return index > size || index < 0;
    }

    public int getSize() {
        return size;
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        MyLinkedList mL = new MyLinkedList();
        mL.addAtHead(1);
        mL.addAtIndex(1,2);
        mL.addAtIndex(2,3);
        mL.addAtIndex(3,4);
//        mL.addAtIndex(1,99);

        for (int i = 0; i < mL.getSize(); i++) {
            System.out.print(mL.get(i) + " ");
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */