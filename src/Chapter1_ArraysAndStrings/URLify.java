package Chapter1_ArraysAndStrings;

/**
 * Created by ashis on 1/2/2017.
 */
public class URLify {

    public String urlify(String input, int realLength) {
        if(input == null) return null;

        char[] inputArr = input.toCharArray();

        int newLength = calculateNewLength(inputArr, realLength);

        if(newLength == realLength) return input;

        int oldPointer = realLength - 1;
        int newPointer = newLength - 1;

        while(oldPointer != newPointer) {
            if(inputArr[oldPointer] == ' ') {
                inputArr[newPointer--] = '0';
                inputArr[newPointer--] = '2';
                inputArr[newPointer--] = '%';
            } else {
                inputArr[newPointer--] = inputArr[oldPointer];
            }
            --oldPointer;
        }

        return new String(inputArr);
    }

    private int calculateNewLength(char[] input, int end) {
        int newLength = end;
        for(int i = 0; i < end; ++i) {
            if(input[i] == ' ') {
                newLength += 2;
            }
        }
        return newLength;
    }
}
