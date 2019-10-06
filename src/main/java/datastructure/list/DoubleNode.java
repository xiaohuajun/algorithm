package datastructure.list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/6 17:01
 * @description 双向链表的节点
 */
public class DoubleNode {

    public int val;

    /**
     * 指向前一个节点的指针
     */
    public DoubleNode prev;

    /**
     * 指向后一个节点的指针
     */
    public DoubleNode next;

    public DoubleNode(int val) {
        this.val = val;
    }
}
