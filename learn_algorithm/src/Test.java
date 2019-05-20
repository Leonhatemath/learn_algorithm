import javax.swing.tree.TreeNode;

/**
 * @author WangXu
 * @date 2019/3/5 0005 - 19:15
 */
public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode t = s.reConstructBinaryTree(pre, in);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class Solution {
        public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
            TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
            return root;
        }
        //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
        private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

            if(startPre>endPre||startIn>endIn)
                return null;
            TreeNode root = new TreeNode(pre[startPre]);

            for(int i=startIn;i<=endIn;i++)
                if(in[i]==pre[startPre]){
                    root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                    root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                    break;
                }

            return root;
        }


    }
}
