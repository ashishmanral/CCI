package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/17/2017.
 */
public class Insertion {

    public int insertMtoN(int m, int n, int j, int i) {
        int mask = ~(((1 << (j - i)) - 1) << i);
        return (m << i) | mask & n;
    }
}
