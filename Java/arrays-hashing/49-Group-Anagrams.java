import java.util.List;
import java.util.HashMap;
// import java.util.Map;
import java.util.ArrayList;

class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<HashMap<String, Integer>, List<String>> hashMap = new HashMap<>();

        for (String str: strs) {    
            HashMap<String, Integer> map = new HashMap<>();
            char [] chars = str.toCharArray();
            for (char c: chars) {
                if(map.containsKey(Character.toString(c))) {
                    map.merge(Character.toString(c), 1, Integer::sum);
                } else {
                    map.put(Character.toString(c), 1);
                }
            }
            if (!hashMap.containsKey(map)) {
                hashMap.put(map, new ArrayList<>());
            }
            hashMap.get(map).add(str);
        }
        
        return new ArrayList<>(hashMap.values());

        // HashMap<HashMap<String, Integer>, List<String>> hashMap = new HashMap<HashMap<String, Integer>, List<String>>();

        // for (String str: strs) {
        //     HashMap<String, Integer> map = new HashMap<String, Integer>(); 
        //     char[] chars = str.toCharArray();

        //     for (char c: chars) {
        //         map.merge(Character.toString(c), 1, Integer::sum);
        //     }

        //     if (hashMap.get(map) == null) {
        //         hashMap.put(map, new ArrayList<>());
        //     }
        //     hashMap.get(map).add(str);
        // }

        // List<List<String>> result = new ArrayList<>(hashMap.values());
        // // result.addAll(hashMap.values());
        // return result;
    }
    
    public static void main(String [] args) {
        GroupAnagram solution = new GroupAnagram();

        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
