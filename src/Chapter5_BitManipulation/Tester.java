package Chapter5_BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by ashis on 1/18/2017.
 */
public class Tester {

    private boolean testNextNumber;

    private Tester nextNumber() {
        testNextNumber = true;
        return this;
    }

    private void beginTest() {
        if(testNextNumber) runNextNumber();
    }

    private void runNextNumber() {
        System.out.println("Testing NextNumber");
        NextNumber testClass = new NextNumber();

        Random rand = new Random();
        for(int i = 0; i< 10; ++i) {
            int num = rand.nextInt();
            System.out.println("CurrNum : " + num + " : " + Integer.toBinaryString(num));
            int next = testClass.getNextNumber(num);
            System.out.println("NextNum : " + next + " : " + Integer.toBinaryString(next));
            int prev = testClass.getPreviousNumber(num);
            System.out.println("PrevNum : " + prev + " : " + Integer.toBinaryString(prev));
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit;

        do {
            System.out.println("Chapter 5 - Bit Manipulation");
            System.out.println("1. NextNumber");
            System.out.println("2. ALL");
            System.out.print("Enter Number : ");
            int num = Integer.parseInt(br.readLine());
            System.out.println();

            switch (num) {
                case 1:
                    new Tester().nextNumber().beginTest();
                    break;
                case 2:
                    new Tester().nextNumber().beginTest();
                    break;
                default:
                    System.out.println("You have to enter between 1-2");
            }
            System.out.print("Main Menu? (y/n) ");
            String answer = br.readLine();
            System.out.println();
            quit = !"y".equals(answer);
        } while (!quit);
    }

}
