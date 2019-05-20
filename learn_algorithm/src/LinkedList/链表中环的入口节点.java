package LinkedList;

/**
 * @author WangXu
 * @date 2019/3/15 0015 - 21:12
 */
public class 链表中环的入口节点 {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead.next == null || pHead.next.next == null) {
            return null;
        }

        ListNode fNode = pHead.next.next;
        ListNode sNode = pHead.next;
        //先确定下是不是有环
        while (fNode != sNode) {
            fNode = fNode.next.next;
            sNode = sNode.next;
        }
        if (sNode == null) {
            return null;
        } else {
            while (pHead != sNode) {
                pHead = pHead.next;
                sNode = sNode.next;
            }
            return pHead;
        }
    }
}
