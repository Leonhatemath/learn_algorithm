package 知识迁移能力;

/**
 * @author WangXu
 * @date 2019/3/29 0029 - 10:23
 */
public class 平衡二叉树 {
    /*输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    * 总结平衡二叉树特点：
    * （1）非叶子节点最多拥有两个子节点；
    * （2）非叶子节值大于左边子节点、小于右边子节点；
    * （3）树的左右两边的层级数相差不会大于1;
    * （4）没有值相等重复的节点;*/
    public static void main(String[] args) {

    }
}

class Solution{
    public boolean IsBalanced_Solution(TreeNode root) {
        return GetDepth(root) != -1;
    }

    /*从底层开始遍历所有的节点
    * 如果底层的子树开始就是非平衡二叉树，就返回-1
    * 是平衡二叉树，就返回该子节点的子树的深度*/
    public int GetDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = GetDepth(root.left);
        if (left == -1) {
            return left;
        }
        int right = GetDepth(root.right);
        if (right == -1) {
            return right;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
