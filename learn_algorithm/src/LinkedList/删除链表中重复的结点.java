package LinkedList;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/3/20 0020 - 19:42
 */
public class 删除链表中重复的结点 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3};
        ListNode pHead = new ListNode(arr[0]);
        ListNode tHead = new ListNode(arr[1]);
        pHead.next = tHead;
        for (int i = 2; i < arr.length; i++) {
            tHead.next = new ListNode(arr[i]);
            tHead = tHead.next;
        }
        pHead = new Solution().deleteDuplication(pHead);
        while (pHead != null) {
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }

    public static class Solution {
        public ListNode deleteDuplication(ListNode pHead){
            //就是从第一个节点开始判断时候与后面的节点值相等
            ListNode fHead = new ListNode(0);
            fHead.next = pHead;
            ListNode sHead = fHead;
            while (pHead != null && pHead.next != null) {
                if (pHead.val == pHead.next.val) {
                    int val = pHead.val;
                    while (pHead != null && val == pHead.val) {
                        //删除的过程中，如果最后两个结点的数值一样，pHead在最后会变成null，这里就会报错
                        pHead = pHead.next;
                        sHead.next = pHead;
                    }
                } else {
                    sHead = pHead;
                    pHead = pHead.next;
                }
            }
            return fHead.next;
        }
    }
}
