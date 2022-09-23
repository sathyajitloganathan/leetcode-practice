import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

class LongestConsecutiveSequence {
    public int longestConsecutiveSequence(int[] nums) {
        PriorityQueue<Integer> sortedNums = new PriorityQueue<Integer>((e1, e2) -> (e1 - e2));
        for (int num: nums) {
            sortedNums.add(num); 
        }

        PriorityQueue<List<Integer>> result = new PriorityQueue<List<Integer>>((e1, e2) -> e2.size() - e1.size());
        List<Integer> lcs = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int prevNum;
            int nextNum = sortedNums.poll();
            if (lcs.size() == 0) {
                lcs.add(nextNum);
            } else {
                prevNum = lcs.get(lcs.size() - 1);
                if ((prevNum + 1) != nextNum && prevNum != nextNum) {
                    result.add(new ArrayList<Integer>(lcs));
                    lcs.clear();
                }
                if (prevNum != nextNum) {
                    lcs.add(nextNum);
                }
            }
        }
        
        if (lcs.size() != 0) {
            result.add(new ArrayList<Integer>(lcs));
        }

        int r = 0;
        if (result.peek() != null) {
            r = result.poll().size();
        }
        return r;
    }    

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        // 0,3,7,2,5,8,4,6,0,1
        // 100,101,102, 103, 104,200,1,3,2
        // 9,1,4,7,3,-1,0,5,8,-1,6
        // 1,2,0,1
        int result = lcs.longestConsecutiveSequence(new int[]{100,101,102, 103, 104,200,1,3,2});

        System.out.println(result);
    }
}
