package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

/**
 * Created by ashis on 1/15/2017.
 */
public class ValidateBST {

    public boolean isBST(TreeNode<Integer> root) {
        return validateBST(root, Integer.MIN_VALUE).isBST;
    }

    private Result validateBST(TreeNode<Integer> root, int num) {
        if(root == null) return new Result(true, num);

        Result left = validateBST(root.left, num);
        boolean thisResult = left.isBST && root.data >= left.num;
        if(!thisResult) return new Result(false, num);;

        return validateBST(root.right, root.data + 1);
    }

    private class Result {
        boolean isBST;
        int num;

        Result(boolean isBST, int num) {
            this.isBST = isBST;
            this.num = num;
        }
    }
}
