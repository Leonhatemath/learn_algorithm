package 知识迁移能力;

/**
 * @author WangXu
 * @date 2019/4/15 0015 - 19:48
 */
public class Solution_二叉树的深度 {
    public static void main(String[] args) {

    }
    public int TreeDepth(TreeNode root,int length) {
        if (root.left == null && root.right == null) {
            return length;
        }
        if (root.left == null) {
            return TreeDepth(root.right, length + 1);
        }
        if (root.right == null) {
            return TreeDepth(root.left, length + 1);
        }
        return TreeDepth(root.left, length + 1) > TreeDepth(root.right, length + 1) ? TreeDepth(root.left, length + 1) : TreeDepth(root.right, length + 1);
    }

    public int Ohter_TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Ohter_TreeDepth(root.left);
        int right = Ohter_TreeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

}
