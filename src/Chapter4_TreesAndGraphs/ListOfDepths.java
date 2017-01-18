package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ashis on 1/15/2017.
 */
public class ListOfDepths {

    public List<LinkedList<TreeNode>> createDepthLists(TreeNode node) {

        List<LinkedList<TreeNode>> listOfDepths = new LinkedList<>();
        LinkedList<TreeNode> currDepth = new LinkedList<>();
        currDepth.add(node);
        listOfDepths.add(currDepth);

        while(!currDepth.isEmpty()) {
            LinkedList<TreeNode> childNodes = new LinkedList<>();
            for(TreeNode curr : currDepth) {
                if(curr.left != null) childNodes.add(curr.left);
                if(curr.right != null) childNodes.add(curr.right);
            }
            if(!childNodes.isEmpty()) {
                listOfDepths.add(childNodes);
            }
            currDepth = childNodes;
        }

        return listOfDepths;

    }
}
