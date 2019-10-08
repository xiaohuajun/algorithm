package datastructure.list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/6 15:22
 * @description 有序链表
 * 插入和删除比数组更高效
 * 一般利用有序链表排序比插入排序更高效
 */
public class SortedList {


    private Node first;

    public SortedList() {
        first = null;
    }

    /**
     * 有序插入--来保证有序
     *
     * @param v 插入的值
     */
    public void insert(int v) {
        Node newNode = new Node(v);
        Node pre = null;
        Node curr = first;
        //找到第一个数值比v大的节点
        while (curr != null && curr.value < v) {
            pre = curr;
            curr = curr.next;
        }
        //两种情况
        //找到的符合条件的节点在first
        if (pre == null) {
            first = curr;
        } else {
            //找到的节点不是第一个
            pre.next = newNode;
            newNode.next = curr;
        }
    }

    /**
     * 删除头结点
     */
    public Node delete() {
        Node tmp = first;
        first = first.next;
        tmp.next = null;
        return tmp;
    }




}
