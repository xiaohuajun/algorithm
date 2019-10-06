package datastructure.queue;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/4 17:45
 * @description 解决了顺序队列中的问题-具体问题
 * @see SequenceQueue
 */
public class LoopQueue<T> {

    private static final int INIT_SIZE = 16;

    private int front;

    private int rear;

    private int capacity;

    private T[] objects;

    public LoopQueue() {
        this.capacity = INIT_SIZE;
        this.objects = (T[]) new Object[capacity];
    }

    public LoopQueue(int size) {
        this.capacity = size;
        this.objects = (T[]) new Object[capacity];
    }

    public boolean isFull() {
        return rear == capacity;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(T obj) {
        if (isFull()) {
            rear = 0;
        }
        objects[rear++] = obj;
    }

    public T take() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the queue is empty");
        }
        T v = objects[front++];
        objects[front++] = null;
        front = front == capacity ? 0 : front;
        return v;
    }


    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(4);
        loopQueue.add(2);
        loopQueue.add(4);
        loopQueue.add(8);
        loopQueue.add(11);
        loopQueue.add(12);
        System.out.println(loopQueue.isFull());
    }
}
