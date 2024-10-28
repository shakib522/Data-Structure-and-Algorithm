package daynamicPrograming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n=0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(f(n,dp));
        System.out.println(fibTabulation(n));
    }
    static int f(int n,int[] dp){
        if (n<=1){
            return n;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = f(n-1,dp)+f(n-2,dp);
    }
    static int fibTabulation(int n){
        int prev2=0;
        int prev=1;
        for (int i=2;i<=n;i++){
            int cur=prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}
