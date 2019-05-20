package 树;

/**
 * @author WangXu
 * @date 2019/3/13 0013 - 10:48
 */
public class Solution_重建二叉树 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution_重建二叉树 s = new Solution_重建二叉树();
        TreeNode rootnode = s.reConstructBinaryTree(pre, in);
        System.out.println(rootnode.val);
        System.out.println(rootnode.left.val);
        System.out.println(rootnode.right.val);
    }

    TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode RootNode = getTreeNode(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return RootNode;
    }

    TreeNode getTreeNode(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {
        /*思路：
         * 将前序：根左右；中序：左根右；后序：左右根搞清楚
         * 再将两种序列的数组排列好分别是:
         * [1, 2, 4, 7, 3, 5, 6, 8]与[4, 7, 2, 1, 5, 3, 8, 6]
         * 再用树和递归的思想，分析找每个根节点，其左右节点的时候，其数值在数组中的下标的规律
         * 例如先根，那么1就是根节点，再根据中序，找出其左右节点以及其后续的数值的位置
         * 再把代码实现，细心些*/
        if (startpre > endpre || startin > endin) {
            return null;
        }
        TreeNode rootNode = new TreeNode(pre[startpre]);
        for (int i = startin; i <= endin; i++) {
            if (in[i] == pre[startpre]) {
                rootNode.left = getTreeNode(pre, startpre + 1, startpre + (i - startin), in, startin, i - 1);
                rootNode.right = getTreeNode(pre, (startpre + 1) + (i - startin), endpre, in, i + 1, endin);
                break;
            }
        }
        return rootNode;
    }

}