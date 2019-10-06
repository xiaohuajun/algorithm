package datastructure.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/22 18:48
 * @description 判断一个单链表是否有环
 */
public class HasCycleForList {


    /**
     * 利用hash 表存储访问过的节点，最多只访问一次
     * 遍历如果当前节点null：已经检测链表尾部的节点-没有环
     * 如果当前节点存在在hash表中则为环链表
     * 时间复杂度：O(N) + O(1)
     * 空间复杂度都是 ：O(N)
     *
     * @param head 头结点
     * @return true/false
     */
    public static boolean hasCycleToFor(Node head) {
        Set<Node> nodeSet = new HashSet<Node>();
        Node curr = head;
        while (curr != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * 定义两个快慢指针，快指针比慢指针每次都多走一步
     * 如果最终相遇，就是环链表
     * 时间复杂度：O(n) 多少个元素决定
     * 空间复杂度：O(1) 就用到两个节点
     * @param head 头节点
     * @return true/ false
     */
    public static boolean hasCycleToTwoPoint(Node head) {

        Node slow = head;
        Node fast = head.next;
        if (head == null || head.next == null) {
            return false;
        }
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
