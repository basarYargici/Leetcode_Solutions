package Arrays;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 22.12.2020
 * <p>
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 * <p>
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */
public class FindNumberswithEvenNumberofDigits {

    //Declare divCount = 1, count = 0
    //Iterate in list
    //  Iterate in element and divide by 10 , divCount ++, until it num /10 = 0
    //  If divCount%2 = 0
    //      count++
    //  divCount = 1
    public static int findNumbers(int[] nums) {
        int divCount = 1, count = 0;
        if (nums.length>500){
            return 0;
        }
        for (int element : nums) {
            if (element<1 || element>Math.pow(10,5)){
                return 0;
            }
            while(element/10 != 0){
                divCount++;
                element /=10;
            }
            if (divCount%2 == 0){
                count++;
            }
            divCount = 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int result = findNumbers(new int[]{12,345,2,6,7896});
        System.out.println(result);
    }

}
