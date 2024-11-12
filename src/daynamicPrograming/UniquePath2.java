package daynamicPrograming;

import java.util.Arrays;

public class UniquePath2 {
    public static void main(String[] args) {
        UniquePath2 path2=new UniquePath2();
        System.out.println(path2.uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] a:dp){
            Arrays.fill(a,1);
        }
        return countPaths2Tabulation(m,n,dp,obstacleGrid);
    }
    static int countPaths2Memoization(int i,int j,int[][] dp,int[][] obstacleGrid){
        //        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        if (i>=0&&j>=0&&obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }else{
            return dp[i][j]=countPaths2Memoization(i-1,j,dp,obstacleGrid)+countPaths2Memoization(i,j-1,dp,obstacleGrid);
        }
    }
    static int countPaths2Tabulation(int m,int n,int[][] dp,int[][] obstacleGrid){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0&&j==0){
                    dp[i][j]=1;
                }else{
                    int up=0;
                    int left=0;
                    if (i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    static int countPaths2TabulationOptimize(int m,int n,int[][] obstacleGrid){
        int[] prev=new int[n];
        Arrays.fill(prev,0);
        for (int i = 0; i < m; i++) {
            int[] temp=new int[n];
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    temp[j]=0;
                }else if(i==0&&j==0){
                    temp[j]=1;
                }else{
                    int up=0;
                    int left=0;
                    if (i>0) up=prev[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
