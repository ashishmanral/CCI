package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/18/2017.
 */
public class Conversion {

    public int conversionCount(int num1, int num2) {
        int num = num1 ^ num2;
        int count = 0;
        for(count = 0; num > 0; num &= (num - 1), ++count);
        return count;
    }
}
