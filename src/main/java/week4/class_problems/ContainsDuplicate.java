package week4.class_problems;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();
        System.out.println(solver.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(solver.containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}