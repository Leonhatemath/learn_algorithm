package 树;

/**
 * @author WangXu
 * @date 2019/4/18 0018 - 17:16
 */
public class Solution_二叉树的下一个节点 {
    public static void main(String[] args) {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //pNode为根节点
        if (pNode.next == null) {
            //走到右子节点，进行中序遍历查找下一节点作为答案
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.left == null && pNode.right == null) {
            //pNode为叶节点
            if (pNode.next.left == pNode) {
                //如果自己为左叶节点，上一级节点为答案
                return pNode.next;
            } else {
                //如果自己为右叶节点,返回上一级并且剪枝再递归
                pNode = pNode.next;
                pNode.left = null;
                pNode.right = null;
            }
        }else{
            //pNode为中间节点
            if (pNode.right != null) {
                //有右子节点就走右子节点，进入中序遍历查找下一个节点
                //一直查找左子节点，最后 一个就是答案
                pNode = pNode.right;
                while (pNode.left != null) {
                    pNode = pNode.left;
                }
                return pNode;
            } else {
                //没有右子节点就返回上一级并且剪枝
                pNode = pNode.next;
                pNode.left = null;
                pNode.right = null;
            }
        }
        return GetNext(pNode);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
