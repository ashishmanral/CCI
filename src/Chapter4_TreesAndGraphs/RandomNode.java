package Chapter4_TreesAndGraphs;

import Utilities.MyTree;
import Utilities.TreeNode;

/**
 * Created by ashis on 1/16/2017.
 */
public class RandomNode {

    public void insert(TreeNode<Integer> parent, int val) {
        TreeNode<Integer> currNode = new TreeNode<>(val);
        currNode.parent = parent;

        if(parent.left == null) {
            parent.right = currNode;
        } else {
            parent.left = currNode;
        }

        while(parent != null) {
            if(currNode == parent.left) {
                ++parent.leftSize;
            } else {
                ++parent.rightSize;
            }
            currNode = parent;
            parent = currNode.parent;
        }
    }

    public TreeNode<Integer> find(TreeNode<Integer> root, int val) {
        if(root == null) {
            return null;
        }

        if(root.data == val) return root;
        TreeNode<Integer> left = find(root.left, val);
        if(left != null) return left;

        return find(root.right, val);
    }

    public void delete(TreeNode<Integer> node) {
        TreeNode<Integer> currNode = node;
        TreeNode<Integer> parent = node.parent;

        if(node == parent.left) parent.left = null;
        if(node == parent.right) parent.right = null;

        while(parent != null) {
            if(currNode == parent.left) {
                --parent.leftSize;
            } else {
                --parent.rightSize;
            }
            currNode = parent;
            parent = currNode.parent;
        }
    }

    public TreeNode<Integer> randomNode(TreeNode<Integer> root) {
        int random = (int)(Math.random() * (root.leftSize + root.rightSize + 1));
        return randomNodeHelper(root, random);
    }

    public TreeNode<Integer> randomNodeHelper(TreeNode<Integer> root, int random) {
        if(root.leftSize == random) {
            return root;
        }

        return random < root.leftSize ? randomNodeHelper(root.left, random) : randomNodeHelper(root.right, random - root.leftSize - 1);
    }

}
