package daynamicPrograming;

import java.util.Arrays;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int len=nums.length;
        int [] ar1=new int[len-1];
        int[] ar2=new int[len-1];
        for (int i = 0; i < len; i++) {
            if (i!=0) ar1[i]=nums[i];
            if (i!=len-1) ar2[i]=nums[i];
        }
        return Math.max(helperDp(ar1),helperDp(ar2));
    }

    int helperDp(int[] nums){
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
