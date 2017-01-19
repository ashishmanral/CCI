package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/18/2017.
 */
public class NextNumber {

    public int getNextNumber(int curr) {
        if(curr == 0 || curr == ~0) {
            return -1;
        }

        int c0 = 0;
        int c1 = 0;
        int iter = 0;

        while(true) {
            if(((1 << iter++) & curr) == 0) {
                if(c1 > 0) {
                    break;
                }
                ++c0;
            } else {
                ++c1;
            }
        }

        return curr + (int)Math.pow(2, c0) + (int)Math.pow(2, c1 - 1) - 1;
    }

    public int getPreviousNumber(int curr) {
        if(curr == 0 || curr == ~0) {
            return -1;
        }

        int c0 = 0;
        int c1 = 0;
        int iter = 0;

        while(true) {
            if(((1 << iter++) & curr) != 0) {
                if(c0 > 0) {
                    break;
                }
                ++c1;
            } else {
                ++c0;
            }
        }

        return curr - (int)Math.pow(2, c1) - (int)Math.pow(2, c0 - 1) + 1;
    }

}
