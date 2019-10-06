package datastructure.queue;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/21 19:31
 * @description 队列的中的节点
 */
public class Node<T> {


    public T value;

    public Node<T> next;


    public Node(T value) {
        this.value = value;
    }


}
