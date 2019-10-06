package datastructure.list;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/4 23:43
 * @description
 */
public class TestList {


    public static void main(String[] args) {
        Node head = new Node(0);
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = four;
       /* four.next = second;*/

        Node heada = new Node(0);
        Node firsta = new Node(1);
        Node seconda = new Node(2);
        Node thirda = new Node(3);
        Node foura = new Node(4);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = four;



        Node ha = head;
        Node hb = heada;
        /*while (null != h) {
            System.out.print(h.value + "->");
            h = h.next;
        }*/
        System.out.println("\n===========反转============");
        //head = ReverseList.reverseList(head);
        System.out.println(IntersectionNode.intersectionNode(ha,hb));
        System.out.println("\n===========是否有环============");
        /*System.out.println( HasCycleForList.hasCycleToTwoPoint(head));*/
        /*while (null != head) {
            System.out.print(head.value + "->");
            head = head.next;
        }*/

    }
}
