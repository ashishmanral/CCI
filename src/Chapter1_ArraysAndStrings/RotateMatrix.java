package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/4/2017.
 */
public class RotateMatrix {

    public int[][] rotateMatrix(int[][] matrix) {
        int dimension = matrix.length;
        int loops = dimension / 2;

        for(int i = 0; i < loops; ++i) {
            int elements = dimension - (i * 2);
            for(int j = 0; j<elements - 1; ++j) {
                int temp = matrix[i+j][i];
                matrix[i+j][i] = matrix[dimension - i - 1][i+j];
                matrix[dimension - i - 1][i+j] = matrix[dimension - 1 - i -j][dimension - 1 - i];
                matrix[dimension - 1 - i -j][dimension - 1 - i] = matrix[i][dimension - 1 -i - j];
                matrix[i][dimension - 1 -i - j] = temp;
            }
        }

        return matrix;
    }
}
