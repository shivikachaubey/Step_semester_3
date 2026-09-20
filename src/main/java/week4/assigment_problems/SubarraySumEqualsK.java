package week4.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();
        System.out.println(solver.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solver.subarraySum(new int[]{1, -1, 0}, 0));
    }
}