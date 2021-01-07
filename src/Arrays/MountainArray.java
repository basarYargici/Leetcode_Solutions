package Arrays;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 30.12.2020
 * <p>
 * en an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */
public class MountainArray {
    public static boolean validMountainArray(int[] arr) {
        boolean isMountain = true, isDecreasing = false;
        int top = arr[0];

        if (arr.length == 1 || arr[1] < top || arr[arr.length - 1] > arr[arr.length - 2]) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > top && !isDecreasing) {
                top = arr[i];
            } else if (arr[i] < top) {
                top = arr[i];
                isDecreasing = true;
            } else {
                isMountain = false;
            }
        }
        return isMountain;
    }

    public static void main(String[] args) {
        boolean res = validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(res);
    }
}
