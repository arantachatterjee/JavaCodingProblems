/*
Leetcode Problem 70. You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1, 2 or 3 steps. In how many distinct ways can you climb to the top?

Recursive solution implemnetation
 */

public class ClimbingStairsRecursive {
    public static void main (String args[]) {
        ClimbingStairsRecursive c = new ClimbingStairsRecursive();
        int result = c.climbingStairs(38);
        System.out.println(result);
    }

    public int climbingStairs (int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else
            return climbingStairs(n - 1) + climbingStairs(n - 2) + climbingStairs(n - 3);
    }
}
