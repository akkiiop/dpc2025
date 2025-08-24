import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append("#");
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"eat","tea","tan","ate","nat","bat"},
            {""},
            {"a"},
            {"abc","bca","cab","xyz","zyx","yxz"},
            {"abc","def","ghi"}
        };
        for (String[] test : testCases) {
            System.out.println(groupAnagrams(test));
        }
    }
}
