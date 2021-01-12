package Arrays;

import java.util.ArrayList;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 13.01.2021
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    /**
     * This function moves all 0's to the end of it while maintaining the relative
     * order of the non-zero elements.
     *
     * @param nums array which we will make operations on
     */
    public static void moveZeroes(int[] nums) {
        int realPtr = 0; // to keep the non-zero position
        int zeroPosition;

        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[realPtr] = nums[i];
                realPtr++;
            }
        }

        zeroPosition = realPtr;

        while (zeroPosition < nums.length) {
            nums[zeroPosition] = 0;
            zeroPosition++;
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
