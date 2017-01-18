package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

/**
 * Created by ashis on 1/16/2017.
 */
public class CommonAncestor {

    public TreeNode<Integer> findCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2) {
        if(root == null) {
            return null;
        }

        TreeNode<Integer> self = root == node1 ? node1 : (root == node2 ? node2 : null);
        if(self != null) {
            return self;
        }

        TreeNode<Integer> left = findCommonAncestor(root.left, node1, node2);
        TreeNode<Integer> right = findCommonAncestor(root.right, node1, node2);

        if(left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }

}
