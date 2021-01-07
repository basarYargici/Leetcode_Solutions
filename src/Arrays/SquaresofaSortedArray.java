package Arrays;

import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 22.12.2020
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 */
public class SquaresofaSortedArray {
    /*
    get the non-decreasing array
    iterate in array
        square all elements
    sort array
    return array
     */

    public static int[] sortedSquares(int[] arr) throws Exception {
        if (arr.length < 1 || arr.length > 10000) throw new Exception("read constraints");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < -10000 || arr[i] > 10000) throw new Exception("read constraints");
            arr[i] *= arr[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) throws Exception {
        int[] result = sortedSquares(new int[]{-7, -3, 2, 3, 11});

        for (int element : result) {
            System.out.print(element + " ");
        }
    }

}
