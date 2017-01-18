package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/2/2017.
 */
public class PalindromePermutation {

    public boolean isPalindromePermutation(String input) {
        if(input == null) return false;

        long[] lookupArr = new long[4];

        for(char c : input.toCharArray()) {
            flipBit((int)c, lookupArr);
        }

        boolean foundOne = false;

        for(int i = 0; i < lookupArr.length; ++i) {
            long result = lookupArr[i];
            boolean isZero = result == 0;
            boolean isOne = isZero ? false : (result & (result - 1)) == 0;
            if(!isZero && !isOne) {
                return false;
            } else if(isOne) {
                if(foundOne) return false;
                foundOne = true;
            }
        }

        return true;
    }

    private void flipBit(int pos, long[] arr) {
        int index = pos % 64;
        int bucket = pos / 64;
        int shift = 63 - index;

        arr[bucket] ^= 1 << shift;
    }
}
