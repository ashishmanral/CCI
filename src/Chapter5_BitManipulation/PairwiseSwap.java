package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/18/2017.
 */
public class PairwiseSwap {

    public int swapPairwise(int num) {
        return ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
    }

}
