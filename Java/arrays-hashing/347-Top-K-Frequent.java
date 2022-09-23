
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        
        // if (k > nums.length) {
        //     return new int[]{};
        // }

        // HashMap<Integer, Integer> hashMap = new HashMap<>();

        // for (int num: nums) {
        //     if (!hashMap.containsKey(num)) {
        //         hashMap.put(num, 1);
        //     } else {
        //         hashMap.merge(num, 1, Integer::sum);
        //     }
        // }

        // PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        // for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
        //     pQueue.add(entry);
        // }

        // int[] res = new int[k];
        // for (int i=0; i < k; i++) {
        //     res[i] = pQueue.poll().getKey();
        // }

        // return res;




        // Runtime: 14 ms, faster than 69.27% of Java online submissions for Top K Frequent Elements.
        // Memory Usage: 49.9 MB, less than 67.04% of Java online submissions for Top K Frequent Elements.
        if (k > nums.length) {
            return new int[]{};
        }

        int[] topK = new int[k];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pQueue.add(entry);
        }
        
        List<Integer> result = new ArrayList<Integer>(k);
        for (int j = 0; j < k; j++) {
            result.add(pQueue.poll().getKey());
        }
        // System.out.println(pQueue.poll());
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7 }, 3);
        System.out.println(result);
    }
}
