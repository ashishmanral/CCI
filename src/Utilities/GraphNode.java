package Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashis on 1/14/2017.
 */
public class GraphNode<T> {

    public T data;
    public boolean isVisited;
    public List<GraphNode<T>> adjacentNodes = new ArrayList<>();

    public GraphNode(T data) {
        this.data = data;
    }

    public void addAdjacentNode(GraphNode<T> nextNode) {
        adjacentNodes.add(nextNode);
    }

    @Override
    public String toString() {
        return data + "";
    }

}
