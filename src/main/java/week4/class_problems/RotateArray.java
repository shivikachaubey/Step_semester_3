package week4.class_problems;

import java.util.Arrays;

public class RotateArray {

    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        k = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        RotateArray solver = new RotateArray();
        System.out.println(Arrays.toString(solver.rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(solver.rotateArray(new int[]{1, 2}, 3)));
    }
}