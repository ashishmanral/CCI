package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/4/2017.
 */
public class StringCompression {

    public String stringCompression(String input) {
        int compressedLength = compressedStringLength(input);
        if(compressedLength >= input.length()) return input;

        char[] arr = input.toCharArray();

        char prev = arr[0];
        int prevCount = 1;

        StringBuilder builder = new StringBuilder(compressedLength);

        for(int i = 1;i<input.length();++i) {
            if(arr[i] != prev) {
                builder.append(prev);
                builder.append(prevCount);
                prev = arr[i];
                prevCount = 0;
            }
            ++prevCount;
        }

        builder.append(prev);
        builder.append(prevCount);

        return new String(builder);
    }

    public int compressedStringLength(String input) {
        if(input.isEmpty()) return 0;

        char[] arr = input.toCharArray();

        char prev = arr[0];
        int currCount = 2;

        for(int i = 1;i<input.length();++i) {
            if(arr[i] != prev) {
                prev = arr[i];
                currCount += 2;
            }
        }

        return currCount;
    }
}
