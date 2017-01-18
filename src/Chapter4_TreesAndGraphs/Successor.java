package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

/**
 * Created by ashis on 1/15/2017.
 */
public class Successor {

    public TreeNode<Integer> findSuccessor(TreeNode<Integer> root) {

        // if there is a right child, find the leftmost
        // child of the right child
        if (root.right != null) {
            TreeNode<Integer> rightNode = root.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            return rightNode;
        }

        // Else return the ancestor whose child is at left
        TreeNode<Integer> parent = root.parent;
        if (parent == null) return null;

        while (parent != null && parent.left != root) {
            root = parent;
            parent = root.parent;
        }

        return parent;
    }
}

