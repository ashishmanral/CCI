package Utilities;

/**
 * Created by ashis on 1/14/2017.
 */
public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;
    public int leftSize;
    public int rightSize;

    public TreeNode(T data) {
        this.data = data;
    }

}
