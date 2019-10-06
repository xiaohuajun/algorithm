package datastructure.list;


/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/22 00:02
 * @description 反转链表
 */
public class ReverseList {


    /**
     * 遍历反转指针法
     * 1、保存当前节点的下一个节点
     * 2、把当前节点的指针指向前一个节点
     * 3、把当前节点置为前一个节点
     * 4、把保存的下一个节点置为当前节点
     * 时间复杂度：n个节点 O(n)
     * 空间复杂度：只有一个pre节点和一个curr节点 O(1)
     *
     * @param head 头结点
     * @return 前一个节点
     */
    public static Node reverseList(Node head) {
        //头结点的之前节点设置为null
        Node pre = null;
        Node curr = head;
        //1    2   3    4
        while (curr != null) {
            //先保存当前节点的指针域，方便下次遍历使用
            // 如果不先保存，就是pre节点，那就不会往下遍历了
            Node nextTemp = curr.next;
            //反转指针的指向前一个节点
            curr.next = pre;
            //把当前节点改为前一个节点
            pre = curr;
            //遍历下一个节点使用
            curr = nextTemp;
        }
        return pre;
    }

    /**
     * 递归实现
     *
     * @param head 头结点
     * @return
     */
    public static Node reverseListRecursion(Node head) {
        //递归的约束条件
        if (head == null || head.next == null) {
            return head;
        }
        //递归--->得到新的尾节点 p
        System.out.println("=====开始递归=========" + head.value);
        Node p = reverseListRecursion(head.next);
        System.out.println("=====开始从尾结点反转=========" + head.value+"->");
       //将当前节点的指针域指向前一节点
        head.next.next = head;
        //将当前节点的指针域置空
        head.next = null;
        //新链表的头结点
        return p;
    }
}
