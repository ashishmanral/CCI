package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

/**
 * Created by ashis on 1/15/2017.
 */
public class CheckBalanced {

    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) >= 0;
    }

    private int isBalancedHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
