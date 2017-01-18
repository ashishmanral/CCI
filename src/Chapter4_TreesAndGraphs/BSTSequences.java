package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ashis on 1/16/2017.
 */
public class BSTSequences {

    public List<LinkedList<Integer>> generateSequences(TreeNode<Integer> root) {
        if(root == null) return null;

        List<LinkedList<Integer>> left = generateSequences(root.left);
        List<LinkedList<Integer>> right = generateSequences(root.right);

        if(left == null && right == null) {
            return addPrefix(new ArrayList<LinkedList<Integer>>(), root.data);
        } else if (left == null) {
            return addPrefix(right, root.data);
        } else if (right == null) {
            return addPrefix(left, root.data);
        } else {
            List<LinkedList<Integer>> allWeaved = new ArrayList<>();
            for(List lInnerList : left) {
                for(List rInnerList : right) {
                    List<LinkedList<Integer>> weaveResult = new ArrayList<>();
                    LinkedList<Integer> prefix = new LinkedList<>();
                    weave(lInnerList, rInnerList, prefix, weaveResult);
                    allWeaved.addAll(weaveResult);
                }
            }
            return addPrefix(allWeaved, root.data);
        }

    }

    private void weave(List<Integer> list1, List<Integer> list2, LinkedList<Integer> prefix, List<LinkedList<Integer>> result) {
        if(list1.isEmpty() && list2.isEmpty()) {
            result.add(prefix);
            return;
        }

        if(!list1.isEmpty()) {
            List<Integer> newList1 = new LinkedList<>(list1);
            LinkedList<Integer> newPrefix = new LinkedList<>(prefix);
            newPrefix.add(newList1.remove(0));
            weave(newList1, list2, newPrefix, result);
        }

        if(!list2.isEmpty()) {
            List<Integer> newList2 = new LinkedList<>(list2);
            LinkedList<Integer> newPrefix = new LinkedList<>(prefix);
            newPrefix.add(newList2.remove(0));
            weave(list1, newList2, newPrefix, result);
        }
    }

    private List<LinkedList<Integer>> addPrefix(List<LinkedList<Integer>> allLists, int prefix) {
        if(allLists.isEmpty()) {
            LinkedList<Integer> innerList = new LinkedList<Integer>();
            allLists.add(innerList);
            innerList.add(prefix);
            return allLists;
        }

        for(LinkedList<Integer> list : allLists) {
            list.addFirst(prefix);
        }

        return allLists;
    }
}
