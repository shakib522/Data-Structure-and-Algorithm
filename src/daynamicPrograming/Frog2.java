package daynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {
    public static void main(String[] args) {
        System.out.println(frogJump2Tabulation());
    }
    public static int frogJump2Tabulation() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scan.nextInt();
        }
        int[] dp = new int[n];
        dp[0]=0;
        for (int i=1;i<n;i++){
            int minStep = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i-j>=0){
                    int jmp=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    minStep=Math.min(jmp,minStep);
                }
            }
            dp[i]=minStep;
        }
        return dp[n-1];
    }
    public static int frogJump2() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scan.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n-1, dp, heights, k);
    }

    public static int helper(int n, int[] dp, int[] heights, int k) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int minJump=Integer.MAX_VALUE;
        for (int i = 1; i <=k; i++) {
            if (n-i>=0){
                int jump=helper(n - i, dp, heights, k) + Math.abs(heights[n] - heights[n - i]);
                minJump=Math.min(jump,minJump);
            }
        }
        return dp[n]=minJump;
    }
}
