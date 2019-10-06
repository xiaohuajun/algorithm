package datastructure.list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/5 18:44
 * @description 链表的操作
 */
public class LinkedList {

    /**
     * 链表中的第一个节点
     */
    private Node first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在链表的头部插入节点
     *
     * @param v 插入节点的数据
     */
    public void insert(int v) {
        Node newNode = new Node(v);
        newNode.next = first;
        first = newNode;
    }

    /**
     * 删除第一个节点
     *
     * @return 返回删除节点的数据
     */
    public int delete() {
        //保存临时节点
        Node tmp = first;
        //将下一个节点作为第一个节点
        first = first.next;
        //原来的第一个节点的引用的删掉
        tmp.next = null;
        return tmp.value;
    }

    public Node find(int k) {
        Node curr = first;
        while (curr.value != k) {
            //找到尾部还是没有k
            if (curr.next == null) {
                return null;
            } else {
                //继续找
                curr = curr.next;
            }
        }
        return curr;
    }

    public Node delete(int v) {
        Node pre = null;
        Node curr = first;
        while (curr.value != v) {
            if (curr.next == null) {
                return null;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        //找到了分为两种情况
        //如果在第一个节点就找到，删除第一个
        if (curr == first) {
            Node tmp = first;
            first = first.next;
            tmp.next = null;
            return tmp;
        } else {
            //跨curr节点-需要删除的节点
            pre.next = curr.next;
            curr.next = null;
            return curr;
        }
    }

}
