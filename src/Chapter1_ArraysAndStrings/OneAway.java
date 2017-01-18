package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/4/2017.
 */
public class OneAway {

    public boolean isOneAway(String input1, String input2) {
        if(input1 == null || input2 == null) return false;

        int length1 = input1.length();
        int length2 = input2.length();

        if(Math.abs(length1 - length2) > 1) return false;

        String longer = length1 > length2 ? input1 : input2;
        String shorter = length1 > length2 ? input2 : input1;

        boolean foundDiff = false;
        boolean equalLength = longer.length() == shorter.length();

        int i = 0;
        int j = 0;

        while(i < longer.length() && j < shorter.length()) {
            if(longer.charAt(i) != shorter.charAt(j)) {
                if(foundDiff) return false;
                foundDiff = true;
                if(equalLength) {
                    ++j;
                }
            } else {
                ++j;
            }
            ++i;
        }

        return true;
    }
}
