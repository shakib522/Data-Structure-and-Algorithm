package daynamicPrograming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] a:dp){
            Arrays.fill(a,1);
        }
        return countPathsOptimize(m-1,n-1,dp);
    }
    static int countPaths(int i,int j){
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        return countPaths(i-1,j)+countPaths(i,j-1);
    }
    static int countPathsMemoization(int i,int j,int[][] dp){
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }else{
            return dp[i][j]=countPathsMemoization(i-1,j,dp)+countPathsMemoization(i,j-1,dp);
        }
    }
    static int countPathsOptimize(int m,int n,int[][] dp){
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    static int countPathsMostOptimize(int m,int n){
        int[] prev=new int[n];
        Arrays.fill(prev,1);
        for (int i = 1; i < m; i++) {
            int[] temp=new int[n];
            temp[0]=1;
            for (int j = 1; j < n; j++) {
                temp[j]=prev[j]+temp[j-1];
            }
            prev=temp;
        }
        return prev[n-1];
    }

}
