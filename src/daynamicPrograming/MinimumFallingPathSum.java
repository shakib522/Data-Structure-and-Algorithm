package daynamicPrograming;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        return solveMemoizationIterativeOptimize(n,m,matrix);
    }
    void solveMemoizationIterative(int n, int m, int[][] matrix, int[][] dp) {
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int straight = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = 100000000;
                int rightDiagonal = 100000000;
                if (j - 1 >= 0) {
                    leftDiagonal = matrix[i][j] + dp[i - 1][j - 1];
                }
                if (j + 1 < m) {
                    rightDiagonal = matrix[i][j] + dp[i - 1][j + 1];
                }
                dp[n][m] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
            }
        }
    }
    int solveMemoizationIterativeOptimize(int n, int m, int[][] matrix) {
        int [] prev=new int[m];
        for (int i = 0; i < m; i++) {
            prev[i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            int [] cur=new int[m];
            for (int j = 0; j < m; j++) {
                int straight = matrix[i][j] + prev[j];
                int leftDiagonal =100000000;
                int rightDiagonal = 100000000;
                if (j - 1 >= 0) {
                    leftDiagonal = matrix[i][j] + prev[j - 1];
                }
                if (j + 1 < m) {
                    rightDiagonal = matrix[i][j] + prev[j + 1];
                }
                cur[j] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
            }
            prev=cur;
        }
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans,prev[i]);
        }
        System.gc();
        return ans;
    }

    int solveMemoization(int n, int m, int[][] matrix, int[][] dp) {
        if (m < 0 || m >= matrix[0].length) {
            return 100000000;
        }
        if (n == 0) {
            dp[n][m] = matrix[0][m];
            return matrix[0][m];
        }
        if (dp[n][m] != -10000000) {
            return dp[n][m];
        }
        int straight = matrix[n][m] + solveMemoization(n - 1, m, matrix, dp);
        int leftDiagonal = matrix[n][m] + solveMemoization(n - 1, m - 1, matrix, dp);
        int rightDiagonal = matrix[n][m] + solveMemoization(n - 1, m + 1, matrix, dp);
        return dp[n][m] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
    }

    int solve(int n, int m, int[][] matrix) {
        if (m < 0 || m >= matrix[0].length) {
            return 100000000;
        }
        if (n == 0) {
            return matrix[0][m];
        }
        int straight = matrix[n][m] + solve(n - 1, m, matrix);
        int leftDiagonal = matrix[n][m] + solve(n - 1, m - 1, matrix);
        int rightDiagonal = matrix[n][m] + solve(n - 1, m + 1, matrix);
        return Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
    }
}