package Chapter4_TreesAndGraphs;

import Utilities.GraphNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by ashis on 1/14/2017.
 */
public class RouteBetweenNodes {

    public boolean isRouteBetweenNodesUsingBFT(GraphNode<Integer> start, GraphNode<Integer> end) {
        if(start == null || end == null) return false;

        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(start);
        start.isVisited = true;

        while(!queue.isEmpty()) {
            GraphNode<Integer> curr = queue.pollFirst();
            if(curr == end) return true;
            for(GraphNode<Integer> nextNode : curr.adjacentNodes) {
                if(!nextNode.isVisited) {
                    nextNode.isVisited = true;
                    queue.add(nextNode);
                }
            }
        }

        return false;
    }

    public boolean isRouteBetweenNodesUsingDFT(GraphNode<Integer> start, GraphNode<Integer> end) {
        if(start == null || end == null) return false;

        Stack<GraphNode> stack = new Stack<>();
        stack.add(start);
        start.isVisited = true;

        while(!stack.isEmpty()) {
            GraphNode<Integer> curr = stack.pop();
            if(curr == end) return true;
            for(GraphNode<Integer> nextNode : curr.adjacentNodes) {
                if(!nextNode.isVisited) {
                    nextNode.isVisited = true;
                    stack.push(nextNode);
                }
            }
        }

        return false;
    }

}
