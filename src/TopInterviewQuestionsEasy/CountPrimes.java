package TopInterviewQuestionsEasy;
// NOT FINISHED

/**
 * Project: Leetcode
 * Package: TopInterviewQuestionsEasy
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 31.12.2020
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: 0
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        int cnt = 0;
        boolean isPrime = true;
        if (n >= 5 * 1000000 || n <= 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int res = countPrimes(5);
        System.out.println(res);
    }

}
