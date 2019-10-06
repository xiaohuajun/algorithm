package list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/22 00:05
 * @description 链表中的节点
 */
public class Node {

    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public void dispaly() {
        System.out.println("{" + value + "-->");
    }


}
