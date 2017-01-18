package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/18/2017.
 */
public class FlipBitToWin {

    public int longestOnesWithOneFlip(int num) {
        int temp = num;

        int max = 1;
        int curr = 0;
        int prev = 0;

        while(num > 0) {
            if((num & 1) == 1) {
                ++curr;
            } else {
                if(prev + curr + 1 > max) {
                    max = prev + curr + 1;
                }
                prev = curr;
                curr = 0;
            }
            num >>>= 1;
        }

        return max;
    }
}
