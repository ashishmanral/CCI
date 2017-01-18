package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/2/2017.
 */
public class CheckPermutation {

    public boolean isPermutation(String string1, String string2) {
        if(string1 == null || string2 == null || string1.length() != string2.length()) return false;

        int[] lookupArr = new int[256];

        for(int i = 0; i < string1.length(); ++i) {
            ++lookupArr[(int)(string1.charAt(i))];
            --lookupArr[(int)(string2.charAt(i))];
        }

        for(int value : lookupArr) {
            if(value != 0) return false;
        }

        return true;
    }

}
