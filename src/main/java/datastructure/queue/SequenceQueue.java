package datastructure.queue;

import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/18 20:47
 * @description 实现一个顺序队列-数组实现
 * 顺序队列有什么问题？
 * 顺序固定，导致队首还有空出的位置，队尾已经到头，无法再插入新的数据
 */
public class SequenceQueue<T> {

    /**
     * 队列的初始化大小
     */
    private static final int INIT_SIZE = 16;
    /**
     * 数组的长度
     */
    private int capacity;

    /**
     * 队列中的元素
     */
    private T[] objects;

    /**
     * 队尾
     */
    private int rear;

    /**
     * 队头
     */
    private int front;


    public SequenceQueue() {
        capacity = INIT_SIZE;
        objects = (T[]) new Object[capacity];
    }

    public SequenceQueue(T obj) {
        this();
        objects[0] = obj;
        rear++;
    }

    public SequenceQueue(T obj, int size) {
        this.capacity = size;
        objects = (T[]) new Object[capacity];
        objects[0] = obj;
        rear++;
    }

    public SequenceQueue(int size) {
        this.capacity = size;
        objects = (T[]) new Object[capacity];
    }


    /**
     * 入队
     *
     * @param obj 入队元素
     */
    public void add(T obj) {
        if (rear > capacity - 1) {
            reSize();
        }
        objects[rear++] = obj;
        //循环队列实现:如果尾指针已经到尾 转向头
        //rear = rear == capacity ? 0 : rear;
    }

    /**
     * 出队
     *
     * @return 队列中的元素
     */
    public T take() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the queue is empty");
        }
        T value = objects[front];
        objects[front++] = null;
        //循环队列实现:如果头指针已经到尾 转向头
        //front = front == capacity ? 0 : rear;
        return value;
    }

    /**
     * 清空队列
     */
    public void clear() {
        Arrays.fill(objects, null);
        front = 0;
        rear = 0;
    }

    /**
     * 如果队列满了，则进行扩容
     */
    private void reSize() {
        int newSize = this.capacity * 2;
        T[] copy = (T[]) new Object[newSize];
        System.arraycopy(this.objects, 0, copy, 0,
                Math.min(objects.length, newSize));
        objects = copy;
    }

    /**
     * @return 是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }


    public int size() {
        return capacity;
    }

    public boolean isFull() {
        return rear == capacity;
    }


    public static void main(String[] args) {
        SequenceQueue<Integer> sequenceQueue = new SequenceQueue<>(4);
        sequenceQueue.add(1);
        sequenceQueue.add(3);
        sequenceQueue.add(5);
        sequenceQueue.add(9);
        System.out.println(sequenceQueue.isFull());
        System.out.println(sequenceQueue.isEmpty());
        System.out.println(sequenceQueue.take());
    }

}
