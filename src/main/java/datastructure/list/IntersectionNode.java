package datastructure.list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/4 23:54
 * @description 找到两个链表的交点
 */
public class IntersectionNode {


    public static Node intersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }
        //指针A
        Node pa = headA;
        //指针B
        Node pb = headB;
        while(pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pa == null ? headA : pb.next;
        }
        return pa;
    }
}
