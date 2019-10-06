package datastructure.queue;


/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/21 13:37
 * @description 队列--保持队列的应有的结构---链表实现
 */
public class LinkedQueue<T> {

    /**
     * 链表队列的大小
     */
    private int capacity;

    /**
     * 头节点
     */
    private Node<T> front;

    /**
     * 尾结点
     */
    private Node<T> rear;

    /**
     * 创建空队列
     */
    public LinkedQueue() {
        front = null;
        rear = null;
    }


    public void add(T element) {
        if (front == null) {
            front = new Node<>(element);
            rear = front;
        } else {
            Node<T> newNode = new Node<>(element);
            rear.next = newNode;
            rear = newNode;
        }
        capacity++;
    }


    public T poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the queue is empty");
        }
        Node<T> tmpNode = front;
        front = front.next;
        tmpNode.next = null;
        capacity--;
        return tmpNode.value;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public int size() {
        return capacity;
    }


    public static void main(String[] args) {

        LinkedQueue<Node> linkedQueue = new LinkedQueue<>();
        Node<Integer> sNode = new Node<>(12);
        Node<Integer> fNode = new Node<>(2);
        Node<Integer> tNode = new Node<>(6);

        linkedQueue.add(sNode);
        linkedQueue.add(fNode);
        linkedQueue.add(tNode);

        System.out.println(linkedQueue.poll().value);

    }
}
