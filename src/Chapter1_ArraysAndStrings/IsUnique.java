package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/2/2017.
 */
public class IsUnique {

    /**
     * Assumes extended ASCII character set.
     *
     * @param input
     * @return
     */
    public boolean isUnique(String input) {
        if(input.length() > 256) {
            return false;
        }

        long[] bitVector = new long[4];

        for(char c : input.toCharArray()) {
            int value = Character.getNumericValue(c);
            if(isBitSet(value, bitVector)) {
                return false;
            }
            setBit(value, bitVector);
        }

        return true;
    }

    private boolean isBitSet(int pos, long[] arr) {
        int index = pos % 64;
        int bucket = pos / 64;
        int shift = 63 - index;

        return (arr[bucket] & (1 << shift)) != 0;
    }

    private void setBit(int pos, long[] arr) {
        int index = pos % 64;
        int bucket = pos / 64;
        int shift = 63 - index;

        arr[bucket] |= 1 << shift;
    }
}
