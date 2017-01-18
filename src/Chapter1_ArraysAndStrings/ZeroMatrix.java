package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/4/2017.
 */
public class ZeroMatrix {

    public int[][] zeroMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean nullifyFirstRow = false;
        boolean nullifyFirstColumn = false;

        // first row
        for(int i = 0; i < n; ++i) {
            if(matrix[0][i] == 0) {
                nullifyFirstRow = true;
                break;
            }
        }

        // first column
        for(int i = 0; i < m; ++i) {
            if(matrix[i][0] == 0) {
                nullifyFirstColumn = true;
                break;
            }
        }

        // rest of the matrix
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify the rest of the matrix
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // nullify first row
        if(nullifyFirstRow) {
            for(int i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }

        // nullify first column
        if(nullifyFirstColumn) {
            for(int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }
}
