package daynamicPrograming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber robber=new HouseRobber();
        int [] dp = new int[5];
        Arrays.fill(dp,-1);
        System.out.println(robber.helperDp(new int[]{2,7,9,3,1},4,dp));
        System.out.println(robber.helperDpIterative(new int[]{2,7,9,3,1}));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helperDp(nums,nums.length-1,dp);
    }

    int helper(int[] nums,int index){
        if (index==0){
            return nums[index];
        }
        if (index<0){
            return 0;
        }
        int pic = nums[index]+helper(nums,index-2);
        int notPic= helper(nums,index-1);
        return Math.max(pic,notPic);
    }
    int helperDp(int[] nums,int index,int []dp){
        if (index==0){
            return nums[index];
        }
        if (index<0){
            return 0;
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int pic = nums[index]+helperDp(nums,index-2,dp);
        int notPic= helperDp(nums,index-1,dp);
        return dp[index]=Math.max(pic,notPic);
    }
    int helperDpIterative(int[] nums){
        int len=nums.length;
        int[] dp = new int[len];
        dp[0]=nums[0];
        for (int i = 1; i < len; i++) {

            int pick=nums[i];
            if (i>1){
                pick+=dp[i-2];
            }
            int notPic = dp[i-1];
            dp[i]=Math.max(pick,notPic);
        }
        return dp[len-1];
    }
    int helperDpIterativeOptimized(int[] nums){
        int len=nums.length;
        int prev=nums[0];
        int prev2=0;
        for (int i = 1; i < len; i++) {
            int pick=nums[i];
            if (i>1){
                pick+=prev2;
            }
            int ans=Math.max(pick,prev);
            prev2=prev;
            prev=ans;
        }
        return prev;
    }
}
