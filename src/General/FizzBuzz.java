package General;

import java.util.Scanner;

/**
 * @author İbrahim Başar YARGICI
 * @date 13.04.2021
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for(int i = 1;i <=n;i++)    {
            if (i % 6 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Buzz");
            else if (i % 2 == 0) System.out.println("Fizz");
            else System.out.println(i);
        }
    }
}
