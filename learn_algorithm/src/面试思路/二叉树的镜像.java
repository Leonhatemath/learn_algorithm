package 面试思路;

import com.oracle.tools.packager.JreUtils;
import jdk.nashorn.api.tree.Tree;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * @author WangXu
 * @date 2019/3/27 0027 - 20:57
 */
public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        } else {
            Exchange(root);
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }

    public void Exchange(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}



