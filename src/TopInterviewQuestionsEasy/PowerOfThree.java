package TopInterviewQuestionsEasy;

/**
 * Project: Leetcode
 * Package: TopInterviewQuestionsEasy
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 31.12.2020
 * <p>
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 9
 * Output: true
 * Example 4:
 * <p>
 * Input: n = 45
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= n <= 2^31 - 1
 */
public class PowerOfThree {
    /*
     Divide n to 3 until it reaches 1
     if result is 1 return true, otherwise false
     */

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return (n == 1);
    }

    public static void main(String[] args) {
        boolean res = isPowerOfThree(0);
        System.out.println(res);
    }
}
