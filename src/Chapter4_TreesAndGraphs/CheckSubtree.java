package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

/**
 * Created by ashis on 1/16/2017.
 */
public class CheckSubtree {

    public boolean isSubtree(TreeNode<Integer> large, TreeNode<Integer> small) {
        StringBuilder largePreOrder = new StringBuilder();
        StringBuilder smallPreOrder = new StringBuilder();

        generatePreOrder(large, largePreOrder);
        generatePreOrder(small, smallPreOrder);

        return largePreOrder.toString().contains(smallPreOrder.toString());
    }

    private void generatePreOrder(TreeNode<Integer> root, StringBuilder builder) {
        if(root == null) {
            builder.append("X");
            return;
        }

        builder.append(root.data);
        generatePreOrder(root.left, builder);
        generatePreOrder(root.right, builder);
    }
}
