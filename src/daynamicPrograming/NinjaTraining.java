package daynamicPrograming;
import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        System.out.println(tabulation(3, new int[][]{{10, 40, 70}, {20, 50, 80}, {30, 60, 90}}));
    }

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper2(n - 1, points, dp, 3);
    }

    //    static int helper(int day,int [][]points,int last){
//        if (day==0){
//            int maxi=0;
//            for (int i = 0; i <= 2; i++) {
//                if (i!=last){
//                    maxi=Math.max(points[day][i],maxi);
//                }
//            }
//            return maxi;
//        }
//        int max=0;
//        for (int i = 0; i <= 2; i++) {
//            if (i!=last){
//                max=Math.max(max,points[day][i]+helper(day-1,points,i));
//            }
//        }
//        return max;
//    }
    static int helper2(int day, int[][] points, int[][] dp, int last) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(points[day][i], maxi);

                }
            }
            return maxi;
        }
        int max = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int point = points[day][i] + helper2(day - 1, points, dp, i);
                max = Math.max(point, max);
            }
        }
        return dp[day][last] = max;
    }

    static int tabulation(int n, int[][] points) {
        int[][] dp = new int[points.length][3];
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = points[i][0]+Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = points[i][1]+Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = points[i][2]+Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }

    static int tabulationOptimized(int n, int[][] points) {
        int prev0 = points[0][0];
        int prev1 = points[0][1];
        int prev2=  points[0][2];
        for (int i = 1; i < n; i++) {
            int zero = points[i][0]+Math.max(prev1, prev2);
            int one = points[i][1]+Math.max(prev0,prev2);
            int two = points[i][2]+Math.max(prev0, prev1);
            prev0=zero;
            prev1=one;
            prev2=two;
        }
        return Math.max(prev0, Math.max(prev1, prev2));
    }
}
