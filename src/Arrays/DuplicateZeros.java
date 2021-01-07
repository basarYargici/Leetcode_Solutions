package Arrays;

/**
 * Project: Leetcode
 * Package: Arrays
 * <p>
 *
 * @author İbrahim Başar YARGICI
 * Date 22.12.2020
 * <p>
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros {
    /*
    get the array, size of array
    create new array with same size
    find zeroes in list
        -> 2. 0 -> start from 2, 3 = 0, 4 = 3. 5 = 4.

     * Input: [1,0,2,3,0,4,5,0] [0,0,0,0,0,0,0,0] [1,0,0,0,0,4,5,0]
               1 0 0 2 3 0 4 5  [1,0,0,2,3,0,0,4]
               1 0 0 2 3 0 0 4
     */

    /*
    public void duplicateZeros(int[] arr) {
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]==0){
                for(int j = arr.length-1;j>i;j--){
                    arr[j] = arr[j-1];
                }
                arr[i+1] = 0;
                i+=1;
            }
        }
    }
     */

    public static void duplicateZeros(int[] arr) {
        int size = arr.length;
        int[] secondArr = new int[size];
        int j = 0;

        if (size > 10000) return;
        for (int i : arr) {
            if (i < 0 || i > 9) return;
            if (i != 0) {
                secondArr[j] = i;
            } else {
                secondArr[j] = 0;
                if (j + 1 < size) {
                    secondArr[j + 1] = 0;
                }
                j++;
            }
            j++;
            if (j >= size) break;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = secondArr[i];
        }

        for (int element : arr) {
            System.out.print(element);
        }
        System.out.println();
        for (int element : secondArr) {
            System.out.print(element);
        }
    }

    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }

}
