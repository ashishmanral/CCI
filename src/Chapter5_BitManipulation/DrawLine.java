package Chapter5_BitManipulation;

/**
 * Created by ashis on 1/18/2017.
 */
public class DrawLine {

    public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int height = (screen.length * 8) / width;
        int from = 8 * y + (x1 / 8);
        int to = 8 * y + (x2 / 8);

        screen[from] = (byte)((1 << (8 - (x1 % 8))) - 1);
        screen[to] = (byte)(((1 << ((x2 % 8) + 1)) - 1) << (7 - (x2 % 8)));

    }
}
