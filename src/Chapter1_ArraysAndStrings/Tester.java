package Chapter1_ArraysAndStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ashis on 1/2/2017.
 */
public class Tester {

    private boolean testIsUnique;
    private boolean testCheckPermutation;
    private boolean testURLify;
    private boolean testPalindromePermutation;
    private boolean testOneAway;
    private boolean testStringCompression;
    private boolean testRotateMatrix;
    private boolean testZeroMatrix;

    private Tester isUnique() {
        testIsUnique = true;
        return this;
    }

    private Tester checkPermutation() {
        testCheckPermutation = true;
        return this;
    }

    private Tester urlify() {
        testURLify = true;
        return this;
    }

    private Tester palindromePermutation() {
        testPalindromePermutation = true;
        return this;
    }

    private Tester oneAway() {
        testOneAway = true;
        return this;
    }

    private Tester stringCompression() {
        testStringCompression = true;
        return this;
    }

    private Tester rotateMatrix() {
        testRotateMatrix = true;
        return this;
    }

    private Tester zeroMatrix() {
        testZeroMatrix = true;
        return this;
    }

    private void beginTest() {
        if(testIsUnique) runIsUniqueTest();
        if(testCheckPermutation) runCheckPermutation();
        if(testURLify) runURLify();
        if(testPalindromePermutation) runPalindromePermutation();
        if(testOneAway) runOneAway();
        if(testStringCompression) runStringCompression();
        if(testRotateMatrix) runRotateMatrix();
        if(testZeroMatrix) runZeroMatrix();
    }

    private void runIsUniqueTest() {
        System.out.println("Testing IsUnique");
        IsUnique testClass = new IsUnique();
        String[] testInput = {"hello world", "hello", "abcd"};
        for(String s : testInput) {
            System.out.println(s + (testClass.isUnique(s) ? " contains " : " does not contain ") + "unique characters");
        }
        System.out.println();
    }

    private void runCheckPermutation() {
        System.out.println("Testing CheckPermutation");
        CheckPermutation testClass = new CheckPermutation();
        String[] testInput1 = {"Hello", "World", "Ashish", "manral"};
        String[] testInput2 = {"lleHo", "Worlds", "ashish", "alrman"};
        for(int i=0;i<testInput1.length;++i) {
            String input1 = testInput1[i];
            String input2 = testInput2[i];
            System.out.println(input1 + " is " + (testClass.isPermutation(input1, input2) ? "" : "not ") + "a permutation of " + input2);
        }
        System.out.println();
    }

    private void runURLify() {
        System.out.println("Testing URLify");
        URLify testClass = new URLify();
        String[] testInput1 = {"Hello World      ", "Ashish Manral         ", "Shweety is very Cutie              "};
        int[] testInput2 = {11, 13, 22};
        for(int i=0;i<testInput1.length;++i) {
            String input1 = testInput1[i];
            int input2 = testInput2[i];
            System.out.println("[" + input1 + "] is URLified to [" + testClass.urlify(input1, input2) + "]");
        }
        System.out.println();
    }

    private void runPalindromePermutation() {
        System.out.println("Testing PalindromePermutation");
        PalindromePermutation testClass = new PalindromePermutation();
        String[] testInput = {"aaccb", "accb", "abcba"};
        for(int i=0;i<testInput.length;++i) {
            String input = testInput[i];
            System.out.println(input + " is " + (testClass.isPalindromePermutation(input) ? "" : "not ") + "a permutation of a palindrome");
        }
        System.out.println();
    }

    private void runOneAway() {
        System.out.println("Testing OneAway");
        OneAway testClass = new OneAway();
        String[] testInput1 = {"pale", "pales", "pale", "pale"};
        String[] testInput2 = {"ple", "pale", "bale", "bake"};
        for(int i=0;i<testInput1.length;++i) {
            String input1 = testInput1[i];
            String input2 = testInput2[i];
            System.out.println(input1 + " and " + input2 + " are " + (testClass.isOneAway(input1, input2) ? "" : "not ") + "one away");
        }
        System.out.println();
    }

    private void runStringCompression() {
        System.out.println("Testing StringCompression");
        StringCompression testClass = new StringCompression();
        String[] testInput = {"aabcccccaaa", "abcd", "aabbccdd"};
        for(int i=0;i<testInput.length;++i) {
            String input = testInput[i];
            System.out.println("[" + input + "] is compressed to [" + testClass.stringCompression(input)  + "]");
        }
        System.out.println();
    }

    private void runRotateMatrix() {
        System.out.println("Testing RotateMatrix");
        RotateMatrix testClass = new RotateMatrix();
        int count = 1;
        int dimension = 10;
        int[][] matrix = new int[dimension][dimension];
        for(int i = 0; i < dimension; ++i) {
            for(int j = 0; j < dimension; ++j) {
                matrix[i][j] = count++;
            }
        }
        System.out.println("Input Matrix:");
        printMatrix(matrix);
        System.out.println("\nOutput Matrix:");
        printMatrix(testClass.rotateMatrix(matrix));
        System.out.println();
    }

    private void runZeroMatrix() {
        System.out.println("Testing ZeroMatrix");
        ZeroMatrix testClass = new ZeroMatrix();
        int rows = 3;
        int columns = 5;
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                matrix[i][j] = (int)(Math.random() * 7);
            }
        }
        System.out.println("Input Matrix:");
        printMatrix(matrix);
        System.out.println("\nOutput Matrix:");
        printMatrix(testClass.zeroMatrix(matrix));
        System.out.println();
    }

    private void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit;

        do {
            System.out.println("Chapter 1 - Arrays and Strings");
            System.out.println("1. CheckPermutation");
            System.out.println("2. IsUnique");
            System.out.println("3. OneAway");
            System.out.println("4. PalindromePermutation");
            System.out.println("5. RotateMatrix");
            System.out.println("6. StringCompression");
            System.out.println("7. URLify");
            System.out.println("8. ZeroMatrix");
            System.out.println("9. ALL");
            System.out.print("Enter Number : ");
            int num = Integer.parseInt(br.readLine());
            System.out.println();

            switch(num) {
                case 1 : new Tester().checkPermutation().beginTest();
                    break;
                case 2 : new Tester().isUnique().beginTest();
                    break;
                case 3 : new Tester().oneAway().beginTest();
                    break;
                case 4 : new Tester().palindromePermutation().beginTest();
                    break;
                case 5 : new Tester().rotateMatrix().beginTest();
                    break;
                case 6 : new Tester().stringCompression().beginTest();
                    break;
                case 7 : new Tester().urlify().beginTest();
                    break;
                case 8 : new Tester().zeroMatrix().beginTest();
                    break;
                case 9 : new Tester().checkPermutation().isUnique().oneAway().palindromePermutation().rotateMatrix().stringCompression().urlify().zeroMatrix().beginTest();
                    break;
                default : System.out.println("You have to enter between 1-9");
            }
            System.out.print("Main Menu? (y/n) ");
            String answer = br.readLine();
            System.out.println();
            quit = !"y".equals(answer);
        } while(!quit);

    }
}
