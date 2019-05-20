package 时间空间效率的平衡;

/**
 * @author WangXu
 * @date 2019/4/23 0023 - 20:56
 */
public class Solution_两个链表的第一个公共点 {
    public static void main(String[] args) {

    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int lenP1 = 0;
        int lenP2 = 0;
        ListNode Node1 = pHead1;
        ListNode Node2 = pHead2;
        while (pHead1 != null) {
            lenP1++;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            lenP2++;
            pHead2 = pHead2.next;
        }
        int DiffValue = Math.abs(lenP1 - lenP2);
        ListNode LongHead;
        ListNode ShortHead;
        if (lenP1 > lenP2) {
            LongHead = Node1;
            ShortHead = Node2;
        } else {
            LongHead = Node2;
            ShortHead = Node1;
        }
        int count = 0;
        while (count < DiffValue) {
            count++;
            LongHead = LongHead.next;
        }
        while (LongHead != ShortHead) {
            LongHead = LongHead.next;
            ShortHead = ShortHead.next;
        }
        return LongHead;

    }
}
