package 树;

import java.util.LinkedList;

/**
 * @author WangXu
 * @date 2019/4/22 0022 - 16:41
 */
public class Solution_二叉搜索树的第K个节点 {
    public static void main(String[] args) {
        String str = "8,6,5,#,#,7,#,#,10,9,#,#,11,#,#,";
        Solution_序列化二叉树 s1 = new Solution_序列化二叉树();
        TreeNode root = s1.Deserialize(str);
        Solution_二叉搜索树的第K个节点 s = new Solution_二叉搜索树的第K个节点();
        TreeNode result = s.KthNode(root, 2);
        System.out.println(result.val);
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k == 0) {
            return null;
        } else {
            LinkedList<TreeNode> nodes = getNode(pRoot, k);
            if (k > nodes.size()) {
                return null;
            } else {
                return nodes.getLast();
            }
        }
    }

    LinkedList<TreeNode> nodes = new LinkedList<>();
    LinkedList<TreeNode> getNode(TreeNode pRoot,int k) {
        if (pRoot == null) {
            return null;
        }
        if (nodes.size() == 0) {
            nodes.add(pRoot);
        } else {
            boolean InsertFlag = false;
            int index = 0;
            while(index < nodes.size()){
                if(pRoot.val < nodes.get(index).val){
                    nodes.add(index,pRoot);
                    InsertFlag = true;
                    break;
                }
                index++;
            }
            if(!InsertFlag){
                nodes.addLast(pRoot);
            }
        }
        while (nodes.size() > k) {
            nodes.removeLast();
        }
        getNode(pRoot.left, k);
        getNode(pRoot.right, k);
        return nodes;
    }
}