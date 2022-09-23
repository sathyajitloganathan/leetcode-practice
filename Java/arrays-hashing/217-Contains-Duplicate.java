import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueElements = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            uniqueElements.add(nums[i]);
            if (uniqueElements.size() != (i+1)) {
                return true;
            }
        }
        return false;

        // Time exceeded
        // int i = 0;
        // while (i < nums.length) {
        //     int j = i + 1;
        //     while (j < nums.length) {
        //         if (nums[i] == nums[j]) {
        //             return true;
        //         }
        //         j++;
        //     }
        //     i++;
        // }
        // return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] { 1,1,1,3,3,4,3,2,4,2 };
        System.out.println(Arrays.toString(arr));
        // [1,1,1,3,3,4,3,2,4,2]

        long startTime =System.nanoTime(); 
        boolean result = solution.containsDuplicate(arr);
        long endTime =System.nanoTime(); 
        System.out.println(result);
        System.out.println("Execution time(ns): " + (endTime - startTime));
    }
}
