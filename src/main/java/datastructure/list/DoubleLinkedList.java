package datastructure.list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/6 16:45
 * @description 双向链表
 * 传统链表的问题：
 * 遍历只能向前，不能后退
 * 双向链表：
 * 一个节点有指向前的previous 还有指向后的next
 * 注意：
 * 假如头结点在左边，从头结点插入可以理解指针指向从左向右：1 ---> 2 - next
 * 假如尾结点在右边，从尾结点插入可以理解指针指向从右向左：1 <--- 2 - previous
 */
public class DoubleLinkedList {

    private DoubleNode first;

    private DoubleNode last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }


    /**
     * 头部插入
     *
     * @param val 插入的节点的数据
     */
    public void insertFirst(int val) {
        DoubleNode newNode = new DoubleNode(val);
        //采双端链表的结构：头结点和尾结点
        //如果链表为空尾节点指向新的节点,理解从尾向头填
        if (isEmpty()) {
            last = newNode;
        } else {
            //头部插入
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
    }

    /**
     * 链表尾部插入
     *
     * @param val 需要插入的值
     */
    public void insertLast(int val) {
        DoubleNode newNode = new DoubleNode(val);
        //如果链表为空，尾部插入——从前往后填,尾结点和头结点都指向一个节点
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        //两种情况：
        //1、first为空的时候，first和last都指向newNode
        //2、first不为空的时候，也许需要重新定义last
        last = newNode;
    }

    /**
     * 在某个特定位置后插入
     * 1、找到k在链表中的位置
     * 2、执行插入
     *
     * @param val 需要插入的值
     * @param k   插入的位置
     */
    public boolean insertAfter(int k, int val) {
        DoubleNode curr = first;
        //找到k的位置
        while (curr.val != k) {
            curr = curr.next;
            if (curr == null) {
                return false;
            }
        }
        DoubleNode newNode = new DoubleNode(val);
        //分两种情况
        //1、curr is last
        //2、curr is not last
        if (curr == last) {
            newNode.next = null;
        } else {
            curr.next = newNode.next;
            curr.next.prev = newNode;
        }
        newNode.prev = curr;
        curr.next = newNode;
        return true;
    }


    /**
     * 删除头部节点
     *
     * @return 返回删除的节点
     */
    public DoubleNode deleteFirst() {
        DoubleNode tmp = first;
        if (first.next == null) {
            last = null;
        } else {
            //删除下一个节点的向前的指针
            first.next.prev = null;
            first = first.next;
            tmp.next = null;
        }
        return tmp;
    }

    /**
     * 删除尾部节点
     *
     * @return 删除的节点
     */
    public DoubleNode deleteLast() {
        DoubleNode tmp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.prev.next = null;
            last = last.prev;
            tmp.prev = null;
        }
        return tmp;
    }

    /**
     * 删除链表中的特定节点
     *
     * @param val 需要删除节点的值
     * @return 被删除的节点
     */
    public DoubleNode deleteKey(int val) {
        DoubleNode curr = first;
        while (curr.val != val) {
            curr = curr.next;
            if (curr == null) {
                return null;
            }
        }
        //也分为两种情况
        //1 curr is first
        //2 curr is last
        if (curr == first) {
            first = first.next;
        } else {
            curr.next = curr.prev.next;
        }
        if (curr == last) {
            last = curr.prev;
        } else {
            curr.next.prev = curr.prev;
        }
        return curr;
    }

}
