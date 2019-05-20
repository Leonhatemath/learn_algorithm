import java.util.Stack;

/**
 * @author WangXu
 * @date 2019/3/13 0013 - 10:09
 */
public class 用两个栈实现队列 {
    public static void main(String[] args) {

    }

    public static class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            if (!stack2.empty()) {
                while (!stack2.empty()) {
                    stack1.push(stack2.pop());
                }
            }
            stack1.push(node);
        }

        public int pop() {
            if (!stack1.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
    }
    }
}
