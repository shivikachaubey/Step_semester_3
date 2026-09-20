package week4.assigment_problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(solver.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solver.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}