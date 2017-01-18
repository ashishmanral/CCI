package Chapter4_TreesAndGraphs;

import Utilities.BTreePrinter;
import Utilities.GraphNode;
import Utilities.TreeNode;
import practice.TreeTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ashis on 1/14/2017.
 */
public class Tester {

    private boolean testRouteBetweenNodes;
    private boolean testMinimalTree;
    private boolean testPathsWithSum;
    private boolean testBSTSequences;

    private Tester routeBetweenNodes() {
        testRouteBetweenNodes = true;
        return this;
    }

    private Tester minimalTree() {
        testMinimalTree = true;
        return this;
    }

    private Tester pathsWithSum() {
        testBSTSequences = true;
        return this;
    }

    private Tester bstSequences() {
        testBSTSequences = true;
        return this;
    }

    private void beginTest() {
        if(testRouteBetweenNodes) runRouteBetweenNodes();
        if(testMinimalTree) runMinimalTree();
        if(testPathsWithSum) runPathsWithSum();
        if(testBSTSequences) runBSTSequences();
    }

    private void runRouteBetweenNodes() {
        System.out.println("Testing RouteBetweenNodes");
        RouteBetweenNodes testClass = new RouteBetweenNodes();

        GraphNode<Integer> testNode1 = generateGraph();
        GraphNode<Integer> testNode2 = testNode1.adjacentNodes.get(0).adjacentNodes.get(0);
        System.out.println("Using BFT : ");
        System.out.println("Nodes are " + (testClass.isRouteBetweenNodesUsingBFT(testNode1, testNode2) ? "":"not ") + "connected.");

        testNode1 = generateGraph();
        testNode2 = testNode1.adjacentNodes.get(0).adjacentNodes.get(0);
        System.out.println("Using DFT : ");
        System.out.println("Nodes are " + (testClass.isRouteBetweenNodesUsingDFT(testNode1, testNode2) ? "":"not ") + "connected.");

        System.out.println();
    }

    private void runMinimalTree() {
        System.out.println("Testing MinimalTree");
        MinimalTree testClass = new MinimalTree();

        int[] testArr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        TreeNode<Integer> result1 = testClass.createBST(testArr1);
        TreeNode<Integer> result2 = testClass.createBST(testArr2);

        System.out.println("BST1 in-order is : ");
        TreeTraversal.inOrder(result1);
        System.out.println("\nBST2 in-order is : ");
        TreeTraversal.inOrder(result2);

        System.out.println();
    }

    private void runPathsWithSum() {
        System.out.println("Testing PathsWithSum");
        PathsWithSum testClass = new PathsWithSum();
        MinimalTree bstGenerator = new MinimalTree();

        int[] testArr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testArr2 = {-6, -5, -4, -3, -2, -1, 7, 8, 9, 10, 11};

        TreeNode<Integer> result1 = bstGenerator.createBST(testArr1);
        TreeNode<Integer> result2 = bstGenerator.createBST(testArr2);

        BTreePrinter.printNode(result1);
        System.out.println("Paths to sum " + 14 + " for above tree are : " + testClass.countPathsWithSum(result1, 14));
        System.out.println();
        BTreePrinter.printNode(result2);
        System.out.println("Paths to sum " + 8 + " for above tree are : " + testClass.countPathsWithSum(result2, 8));

        System.out.println();
    }

    private void runBSTSequences() {
        System.out.println("Testing BSTSequences");
        BSTSequences testClass = new BSTSequences();
        MinimalTree bstGenerator = new MinimalTree();

        int[] testArr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] testArr2 = {-6, -5, -4, -3, -2, -1, 7, 8, 9, 10, 11};

        TreeNode<Integer> result1 = bstGenerator.createBST(testArr1);
        TreeNode<Integer> result2 = bstGenerator.createBST(testArr2);

        BTreePrinter.printNode(result1);
        System.out.println("All possible BST sequences for above tree are : ");
        printAllBSTSequences(testClass.generateSequences(result1));

        System.out.println();
    }

    private void printAllBSTSequences(List<LinkedList<Integer>> result) {
        for(LinkedList<Integer> sequences : result) {
            for(Integer i : sequences) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private GraphNode generateGraph() {
        GraphNode<Integer> n1 = new GraphNode(10);
        GraphNode<Integer> n2 = new GraphNode(20);
        GraphNode<Integer> n3 = new GraphNode(30);
        GraphNode<Integer> n4 = new GraphNode(40);
        GraphNode<Integer> n5 = new GraphNode(50);
        GraphNode<Integer> n6 = new GraphNode(60);
        GraphNode<Integer> n7 = new GraphNode(70);

        n1.addAdjacentNode(n2);
        n1.addAdjacentNode(n3);
        n2.addAdjacentNode(n4);
        n2.addAdjacentNode(n5);
        n2.addAdjacentNode(n6);
        n3.addAdjacentNode(n7);
        n6.addAdjacentNode(n7);
        n7.addAdjacentNode(n6);

        return n1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit;

        do {
            System.out.println("Chapter 4 - Trees and Graphs");
            System.out.println("1. RouteBetweenNodes");
            System.out.println("2. MinimalTree");
            System.out.println("3. PathsWithSum");
            System.out.println("4. BSTSequences");
            System.out.println("13. ALL");
            System.out.print("Enter Number : ");
            int num = Integer.parseInt(br.readLine());
            System.out.println();

            switch(num) {
                case 1 : new Tester().routeBetweenNodes().beginTest();
                    break;
                case 2 : new Tester().minimalTree().beginTest();
                    break;
                case 3 : new Tester().pathsWithSum().beginTest();
                    break;
                case 4 : new Tester().bstSequences().beginTest();
                    break;
                case 13 : new Tester().routeBetweenNodes().minimalTree().pathsWithSum().bstSequences().beginTest();
                    break;
                default : System.out.println("You have to enter between 1-13");
            }
            System.out.print("Main Menu? (y/n) ");
            String answer = br.readLine();
            System.out.println();
            quit = !"y".equals(answer);
        } while(!quit);

    }

}
