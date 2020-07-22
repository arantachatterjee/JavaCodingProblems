import java.util.Arrays;

public class ClimbingStairsMemoization {

    public static void main(String args[]) {
        int result = climbStairs(3);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairs(n, memo);
    }

    public static int climbStairs(int n, int[] memo) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (memo[n] > -1)
            return memo[n];
        else {
            memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
            return memo[n];
        }
    }
}
