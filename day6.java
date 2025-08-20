import java.util.*;
public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();
        
        Map<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            
            if (arr[i] == 0) {
                result.add(new int[]{i, i});
            }
            
            if (currentSum == 0) {
                result.add(new int[]{0, i});
            }

            if (prefixSumMap.containsKey(currentSum)) {
                for (int startIndex : prefixSumMap.get(currentSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
      
            prefixSumMap.computeIfAbsent(currentSum, k -> new ArrayList<>()).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);
        
        for (int[] subarray : zeroSumSubarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}
