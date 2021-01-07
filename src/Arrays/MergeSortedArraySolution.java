package Arrays;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 23.12.2020
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class MergeSortedArraySolution {
    /*
    m is real size of nums1
    start from m+1 and insert nums2
    sort array
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int temp;
        int size = m + n;
        for (int i = m; i < size; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        for (int i = 0; i < size-1; i++) {
            for (int k = i+1; k < size; k++) {
                if (nums1[k] < nums1[i]) {
                    temp = nums1[k];
                    nums1[k] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }

        /*
        int lenOne = nums1.length;
        int j = 0;
        for (int i = m; i < lenOne; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
         */
    }

    public static void main(String[] args) {
        merge(new int[]{0,1,2,0,0,0},3,new int[]{0,1,-5},3);
    }

}
