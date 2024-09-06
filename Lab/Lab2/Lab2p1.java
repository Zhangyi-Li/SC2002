package Lab2;

import java.util.Scanner;

public class Lab2p1 {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Perform the following methods:");
            System.out.println("1: miltiplication test");
            System.out.println("2: quotient using division by subtraction");
            System.out.println("3: remainder using division by subtraction");
            System.out.println("4: count the number of digits");
            System.out.println("5: position of a digit");
            System.out.println("6: extract all odd digits");
            System.out.println("7: quit");
            choice = sc.nextInt();

            int m = 0, n = 0;
            switch (choice) {
                case 1: /* add mulTest() call */
                    mulTest(sc);
                    break;
                case 2: /* add divide() call */

                    System.out.println("Value of m: ");
                    m = sc.nextInt();
                    System.out.println("Value of n: ");
                    n = sc.nextInt();
                    divide(m, n);
                    break;
                case 3: /* add modulus() call */
                    System.out.println("Value of m: ");
                    m = sc.nextInt();
                    System.out.println("Value of n: ");
                    n = sc.nextInt();
                    modulus(m, n);
                    break;
                case 4: /* add countDigits() call */
                    System.out.println("Value of n: ");
                    n = sc.nextInt();
                    countDigits(n);
                    break;
                case 5: /* add position() call */
                    System.out.println("Value of n: ");
                    n = sc.nextInt();
                    System.out.println("Value of digit: ");
                    m = sc.nextInt();
                    position(n, m);
                    break;
                case 6: /* add extractOddDigits() call */
                    System.out.println("Value of n: ");
                    n = sc.nextInt();
                    extractOddDigits(n);
                    break;
                case 7:
                    System.out.println("Program terminating ….");
            }
        } while (choice < 7);
    }
    /* add method code here */

    public static void mulTest(Scanner sc) {
        int[] num = { 0, 0 };
        int mathCount = 5, userInput = 0, ans = 0, score = 0;

        for (int i = 0; i < mathCount; i++) {
            num[0] = (int) (Math.random() * 9) + 1;
            num[1] = (int) (Math.random() * 9) + 1;
            ans = num[0] * num[1];
            System.out.printf("How much is %d times %d? ", num[0], num[1]);
            userInput = sc.nextInt();

            if (userInput == ans)
                score++;
        }
        System.out.printf("%d answers out of 5 are correct.\n", score);
        System.out.println("-------------------------");

    }

    public static void divide(int m, int n) {
        int counter = 0, temp = m;
        if (m < n)
            System.out.printf("%d/%d = 0", m, n);
        else {
            while (temp > 0) {
                temp -= n;
                if (temp >= 0)
                    counter++;
            }
            System.out.printf("%d/%d = %d \n", m, n, counter);
        }
        System.out.println("-------------------------");

    }

    public static void modulus(int m, int n) {
        int temp = m;
        if (m < n)
            System.out.printf("%d/%d = %d", m, n, m);
        else {
            while (temp >= n) {
                temp -= n;
            }
            System.out.printf("%d/%d = %d \n", m, n, temp);
        }
        System.out.println("-------------------------");
    }

    public static void countDigits(int n) {
        int temp = n, counter = 0;
        if (n <= 0)
            System.out.printf("n : %d - Error input!! \n", n);
        else {
            while (temp > 0) {
                temp = temp / 10;
                counter++;
            }
            System.out.printf("n : %d - count = %d \n", n, counter);

        }

    }

    public static void position(int n, int digit) {
        int temp = n, lastDigit = 0, counter = 0, pos = -1;
        if (n <= 0)
            System.out.printf("position = -1 \n");
        else {
            while (temp > 0) {
                counter++;

                if (temp > 10) {
                    // lastDigit = temp - (temp / 10 * 10);
                    lastDigit = temp % 10;
                    temp = temp / 10;
                } else {
                    lastDigit = temp;
                    temp = 0;
                }

                if (digit == lastDigit)
                    pos = counter;
            }
            System.out.printf("position = %d \n", pos);

        }

    }

    public static void extractOddDigits(int n) {
        int temp = n, lastDigit = 0, oddDigit = 0, counter = 0;
        if (n <= 0)
            System.out.printf("oddDigits = Error input!! \n");
        else {
            while (temp > 0) {

                if (temp > 10) {
                    lastDigit = temp % 10;
                    temp = temp / 10;
                } else {
                    lastDigit = temp;
                    temp = 0;
                }

                if (lastDigit % 2 == 1) {
                    oddDigit += lastDigit * Math.pow(10, counter);
                    counter++;
                }
            }
            System.out.printf("oddDigits = %d \n", oddDigit);

        }

    }
}
