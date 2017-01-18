package Chapter4_TreesAndGraphs;

import Utilities.TreeNode;

import java.util.*;

/**
 * Created by ashis on 1/16/2017.
 */
public class PathsWithSum {

    public int countPathsWithSum(TreeNode<Integer> root, int sum) {
        return countPathsWithSumHelper(root, new HashMap<Integer, Integer>(), sum);
    }

    private int countPathsWithSumHelper(TreeNode<Integer> root, Map<Integer, Integer> runningSums, int sum) {
        if(root == null) return 0;

        Map<Integer, Integer> newRunningSums = new HashMap<>();

        for(int i : runningSums.keySet()) {
            int newSum = root.data + i;
            newRunningSums.put(newSum, runningSums.get(i));
        }

        newRunningSums.put(root.data, newRunningSums.getOrDefault(root.data, 0) + 1);

        int left = countPathsWithSumHelper(root.left, newRunningSums, sum);
        int right = countPathsWithSumHelper(root.right, newRunningSums, sum);

        return left + right + newRunningSums.getOrDefault(sum, 0);
    }
}
