import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // HashMap<Integer, Integer> hashMap = new HashMap<Interger, Integer>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (!hashMap.containsKey(target-nums[i])) {
        //         hashMap.put(num[i], i);
        //     } else {
        //         return new int[]{i, hashMap.get(target-nums[i])};
        //     }
        // }
        // return new int[]{-1, -1};


        HashMap<Integer, Integer> valueIndexPairs = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!valueIndexPairs.containsKey(target - nums[i])) {
                valueIndexPairs.put(nums[i], i);
            } else {
                return new int[]{valueIndexPairs.get(target - nums[i]), i};
            }
        }
        return new int[0];



        // Runtime: 75 ms, faster than 26.62% of Java online submissions for Two Sum.
        // Memory Usage: 42.4 MB, less than 85.94% of Java online submissions for Two Sum.
        // int[] indexPair = new int[2];
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if ((nums[i] + nums[j]) == target) {
        //             indexPair[0] = i;
        //             indexPair[1] = j;
        //             return indexPair;
        //         }
        //     }
        // }
        // return indexPair;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1,2,3,4,5,6};
        int[] result = solution.twoSum(input, 6);
        System.out.println(result.toString());
    }
}
