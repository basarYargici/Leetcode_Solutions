package Arrays;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 30.12.2020
 * <p>
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * <p>
 * More formally check if there exists two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 * <p>
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 * <p>
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class DoubleExist {
    public static boolean checkIfExist(int[] arr) {
        /*

        int size = arr.length;
        int a = 0;
        for(int k = 0; k<size ; k++){
            for(int i = 0; i<size ; i++){
              if(arr[i]*2 == arr[k]&& i!=k){
                  return true;
              }
            }
        }

        return false;
         */
        boolean isExist = false;
        int j = 0;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[j] == 2 * arr[i] || arr[j] * 2 == arr[i]) && i != j) {
                isExist = true;
            } else if (i == arr.length - 1 && !isExist && j != arr.length - 1) {
                i = 0;
                j++;
            }
        }
        return isExist;
    }

    public static void main(String[] args) {
        boolean res = checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8});
        System.out.println(res);
    }

}
