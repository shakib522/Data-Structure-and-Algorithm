package daynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle triangle=new Triangle();
        List<List<Integer>> list=new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(triangle.minimumTotal(list));

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        return findTabulationOptimize(n,m,triangle);
    }
//    int find(int n,int m,List<List<Integer>> triangle){
//        if(n==0){
//            return triangle.get(0).get(0);
//        }
//        int up=0;
//        int left=0;
//        if (m>=triangle.get(n).size()){
//            return 100000000;
//        }
//        int ans=Integer.MAX_VALUE;
//        if(n==triangle.size()-1){
//            for (int i = 0; i < triangle.get(n).size(); i++) {
//                up=triangle.get(n).get(i)+find(n-1,i,triangle);
//                if(i>0){
//                    left=triangle.get(n).get(i)+find(n-1,i-1,triangle);
//                }else{
//                    left=100000000;
//                }
//                ans=Math.min(ans,Math.min(up,left));
//            }
//        }else{
//            if(m>0){
//                up=triangle.get(n).get(m)+find(n-1,m,triangle);
//            }else{
//                up=100000000;
//            }
//            if(m>0){
//                left=triangle.get(n).get(m)+find(n-1,m-1,triangle);
//            }else{
//                left=100000000;
//            }
//            return Math.min(up,left);
//        }
//        return ans-1;
//    }

    int find(int i,int j,List<List<Integer>> triangle){
       if (i== triangle.size()-1){
           return triangle.get(triangle.size()-1).get(j);
       }
       int down=triangle.get(i).get(j)+find(i+1,j,triangle);
       int right=triangle.get(i).get(j)+find(i+1,j+1,triangle);
       return Math.min(down,right);
    }
    int findMemoize(int i,int j,List<List<Integer>> triangle,int[][]dp){
        if (i== triangle.size()-1){
            return triangle.get(triangle.size()-1).get(j);
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+findMemoize(i+1,j,triangle,dp);
        int right=triangle.get(i).get(j)+findMemoize(i+1,j+1,triangle,dp);
        return dp[i][j] = Math.min(down,right);
    }
    int findTabulation(int n,int m,List<List<Integer>> triangle,int[][]dp) {
        for (int j = 0; j <= m; j++) {
            dp[n][j] = triangle.get(n).get(j);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int right = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
    int findTabulationOptimize(int n,int m,List<List<Integer>> triangle) {
        int[] front=new int[m];
        for (int j = 0; j < m; j++) {
           front[j] = triangle.get(n-1).get(j);
        }
        for (int i = n - 2; i >=0; i--) {
            int[] cur=new int[m];
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + front[j];
                int right = triangle.get(i).get(j) + front[j + 1];
                cur[j] = Math.min(down, right);
            }
            front=cur;
        }
        return front[0];
    }
}
