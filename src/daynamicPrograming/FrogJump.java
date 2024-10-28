package daynamicPrograming;

import java.util.Arrays;


public class FrogJump {
    public static int frogJumpIterative(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int firstStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1) {
                secondStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(firstStep, secondStep);
        }
        return dp[n - 1];
    }

    public static int frogJumpWithoutArray(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int firstStep = prev + Math.abs(heights[i] - heights[i - 1]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1) {
                secondStep = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int ans = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n - 1, dp, heights);
    }

    public static int helper(int n, int[] dp, int[] heights) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = helper(n - 1, dp, heights) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = helper(n - 2, dp, heights) + Math.abs(heights[n] - heights[n - 2]);

        }
        return dp[n] = Math.min(left, right);
    }
}