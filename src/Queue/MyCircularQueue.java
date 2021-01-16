package Queue;

// Note: Circular Array implementation assuming there should be empty index between front and rear

/**
 * Project: Leetcode
 * Package: Queue
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 16.01.2021
 * <p>
 * Implementation the MyCircularQueue class:
 * <p>
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 */
public class MyCircularQueue {
    private final int size;
    private int readPtr;
    private int writePtr;
    private int distance;
    private final int[] circularQueue;

    /**
     * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
     *
     * @param k is the size of circular queue
     */
    public MyCircularQueue(int k) {
        circularQueue = new int[k];
        size = k - 1;
        readPtr = 0;
        writePtr = 0;
        distance = 0;
    }

    /**
     * boolean enQueue(int value) Inserts an element into the circular queue.
     * Return true if the operation is successful.
     *
     * @param value is the element to insert queue
     * @return if value inserted into queue, true, otherwise false
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (writePtr == size) {
            circularQueue[writePtr] = value;
            writePtr = 0;
        } else {
            circularQueue[writePtr] = value;
            writePtr++;
        }
        updateDistance(writePtr,readPtr);
        return true;
    }

    /**
     * boolean deQueue() Deletes an element from the circular queue.
     * Return true if the operation is successful.
     *
     * @return if value removed from queue, true, otherwise false
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        readPtr++;
        updateDistance(writePtr,readPtr);
        return true;
    }

    /**
     * int Front() Gets the front item from the queue. If the queue is empty, return -1.
     *
     * @return if queue is not empty, front item, otherwise -1
     */
    public int Front() {
        if (isEmpty()) return -1;
        return circularQueue[readPtr];
    }

    /**
     * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
     *
     * @return if queue is not empty, last item, otherwise -1
     */
    public int Rear() {
        if (isEmpty()) return -1;
        if (isFull()) return circularQueue[writePtr-1];
        if (writePtr == 0){
            return circularQueue[size];
        }
        return circularQueue[writePtr];
    }

    /**
     * boolean isEmpty() Checks whether the circular queue is empty or not.
     *
     * @return true if read pointer is equal to write pointer
     */
    public boolean isEmpty() {
        return readPtr == writePtr;
    }

    /**
     * boolean isFull() Checks whether the circular queue is full or not.
     *
     * @return true if distance from read pointer to write pointer is equal to size, otherwise false
     */
    public boolean isFull() {
        return distance == size;
    }

    private void updateDistance(int write,int read){
        distance = Math.abs(write - read);
    }

}

class Test {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println();
        /*
         * --enqueue--
         * r w
         * 1(0)0
         * --enqueue--
         * r  w
         * 12(0)
         * false
         * false
         * 2
         * true
         * --dequeue--
         *  r w
         * 12(0)
         * --enqueue--
         *  w r
         * (1)24
         * 4
         * Numbers written in brackets are the next indexes to enqueue
         */
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */