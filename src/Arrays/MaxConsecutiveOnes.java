package Arrays;

import java.lang.reflect.Array;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 18.12.2020
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    // start from first index declare count, max
    // take the number and index
    // if index +1 .. same with number -> count ++, max =count
    // search other numbers count
    // if otherscount < max -> print number
    // else others count = max -> repeat
    public static int findMaxConsecutiveOnes(int[] nums) {
            int count = 0, max = 0;
            if (nums.length > 10000 || nums.length == 0) return 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count++;
                    if (count > max) {
                        max = count;
                    }
                }else {
                    count = 0;
                }
            }
            //System.gc();
            return max;
    }

    public static void main(String[] args) {
        int a = findMaxConsecutiveOnes(new int[]{1,0,1,1,1,1,0,0,1,0,1,1});
        System.out.println(a);
    }
}