package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author WangXu
 * @date 2019/3/9 0009 - 15:46
 */
public class 链表输出 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.run();
    }

    public static class Solution {
        public void run() {
            ListNode first = new ListNode(1);
            ListNode next = new ListNode(2);
            first.next = next;
            int[] arrtwo = {1, 2, 3, 4, 5};
            for (int i = 2; i < arrtwo.length; i++) {
                ListNode temp = new ListNode(arrtwo[i]);
                next.next = temp;
                next = temp;
            }
            ArrayList list = printListFromTailToHead(first);
            System.out.println(list);
        }

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> temp = new Stack<>();
            ArrayList<Integer> newList = new ArrayList<>();
            ListNode t = listNode;

            while( t != null ){
                temp.push(t.val);
                t = t.next;
            }
            while( !temp.empty() ){
                newList.add(temp.pop());
            }
            return newList;

        }

        public class ListNode {
            int val;
            ListNode next = null;
            ListNode(int val) {
                this.val = val;
            }
        }
    }

    
}
