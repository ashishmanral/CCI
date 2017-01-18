package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/18/2017.
 */
public class BinaryToString {

    public String convertBinaryToString(double number) {
        StringBuilder builder = new StringBuilder();

        if(number <=0 || number >= 1) {
            return "ERROR";
        }

        builder.append(".");

        while(number > 0) {
            if(builder.length() >= 32) {
                return "ERROR";
            }

            double newNum = number * 2;

            if(newNum >= 1) {
                number = newNum - 1;
                builder.append(1);
            } else {
                number = newNum;
                builder.append(0);
            }
        }

        return builder.toString();
    }
}
