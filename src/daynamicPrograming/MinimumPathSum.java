package daynamicPrograming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum min = new MinimumPathSum();
        System.out.println(min.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
//        int[][] dp =new int[n][m];
        return findTabulationOptimize(n, m, grid);
    }

    int find(int n, int m, int[][] grid) {
        if (n == 0 && m == 0) {
            return grid[0][0];
        }
        if (n < 0 || m < 0) {
            return 10000;
        }
        int up = grid[n][m] + find(n - 1, m, grid);
        int left = grid[n][m] + find(n, m - 1, grid);
        return Math.min(up, left);
    }

    int findMemoization(int n, int m, int[][] grid, int[][] dp) {
        if (n == 0 && m == 0) {
            return grid[0][0];
        }
        if (n < 0 || m < 0) {
            return 10000;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        int up = grid[n][m] + findMemoization(n - 1, m, grid, dp);
        int left = grid[n][m] + findMemoization(n, m - 1, grid, dp);
        dp[n][m] = Math.min(up, left);
        return dp[n][m];
    }

    int findTabulation(int n, int m, int[][] grid, int[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up;
                    int left;
                    if (i > 0) {
                        up = grid[i][j] + dp[i - 1][j];
                    } else {
                        up = 10000;
                    }
                    if (j > 0) {
                        left = grid[i][j] + dp[i][j - 1];
                    } else {
                        left = 10000;
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    int findTabulationOptimize(int n, int m, int[][] grid) {
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] cur = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = grid[i][j];
                } else {
                    int up;
                    int left;
                    if (i > 0) {
                        up = grid[i][j] + prev[j];
                    } else {
                        up = 100000;
                    }
                    if (j > 0) {
                        left = grid[i][j] + cur[j - 1];
                    } else {
                        left = 100000;
                    }
                    cur[j] = Math.min(up, left);
                }
            }
            prev = cur;
        }
        return prev[m - 1];
    }
}
