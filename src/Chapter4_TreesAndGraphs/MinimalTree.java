package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

/**
 * Created by ashis on 1/14/2017.
 */
public class MinimalTree {

    public TreeNode<Integer> createBST(int[] arr) {
        return createBSTHelper(0, arr.length - 1, arr);
    }

    public TreeNode<Integer> createBSTHelper(int low, int high, int[] arr) {
        if(low > high) return null;

        int middle = (low + high) / 2;
        TreeNode<Integer> node = new TreeNode(arr[middle]);

        node.left = createBSTHelper(low, middle - 1, arr);
        node.right = createBSTHelper(middle + 1, high, arr);

        return node;
    }
}
