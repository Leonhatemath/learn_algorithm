package 树;

/**
 * @author WangXu
 * @date 2019/4/20 0020 - 9:32
 */
public class Solution_序列化二叉树 {
    public static void main(String[] args) {
        String str = "8,6,5,#,#,7,#,#,10,9,#,#,11,#,#,";
        Solution_序列化二叉树 s = new Solution_序列化二叉树();
        TreeNode root = s.Deserialize(str);
        System.out.println(root.val);

    }

    int index = -1;
    //把返回的string添加上去就可以了，不用传入string
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    //采用下标来计算的方法比传入子字符串的方法要好得多，不用产生新的字符串对象
    TreeNode Deserialize(String str) {
        index++;
        String[] strr = str.split(",");
        TreeNode node = null;
        if (strr[index].equals("#")) {
            return node;
        } else {
            node = new TreeNode(Integer.parseInt(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    //这是传入子字符串的方法，这个方法有问题
    // 传入的字符串的位置不好弄,可能有数字有多个字符的啊比如10
    TreeNode My_Deserialize(String str) {
        TreeNode node = null;
        char c = str.charAt(0);
        int len = str.length();
        if (c == '#') {
            return node;
        } else {
            node = new TreeNode(Character.getNumericValue(c));
            node.left = My_Deserialize(str.substring(2, 2 + (len - 2) / 2));
            node.right = My_Deserialize(str.substring(2 + (len - 3) / 2, len));
        }
        return node;
    }
}
