import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);

        for (List<Integer> l : result) {
            System.out.print("[  ");
            for (Integer i : l) {
                System.out.print("  " + i + "  ");
            }
            System.out.print("  ]");
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new LinkedList();

        if (nums.length == 0) return result;

        Arrays.sort(nums);

        int end = nums.length;

        for (int num1 = 0; num1 < end - 2; num1++) {
            for (int num2 = num1 + 1; num2 < end - 1; num2++) {
                for (int num3 = num2 + 1; num3 < end; num3++) {
                    if (nums[num1] + nums[num2] + nums[num3] == 0)
                        result.add(Arrays.asList(nums[num1], nums[num2], nums[num3]));
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new LinkedList();

        if (nums.length == 0) return result;

        Arrays.sort(nums);

        int end = nums.length;

        for (int num1 = 0; num1 < end - 2; num1++) {
            for (int num2 = num1 + 1; num2 < end - 1; num2++) {
                for (int num3 = num2 + 1; num3 < end; num3++) {
                    if (nums[num1] + nums[num2] + nums[num3] == 0) {
                        List<Integer> set = Arrays.asList(nums[num1], nums[num2], nums[num3]);
                        if (!result.contains(set))
                            result.add(set);
                    }
                }
            }
        }
        return result;
    }
}
