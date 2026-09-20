package week4.class_problems;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        System.out.println(Arrays.toString(solver.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solver.twoSum(new int[]{3, 2, 4}, 6)));
    }
}