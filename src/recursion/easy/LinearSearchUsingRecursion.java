package recursion.easy;

import java.util.ArrayList;

public class LinearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] ar={2,5,34,76,12,12,7,11};
        int target=12;
        System.out.println(linearSearch(ar,target,0));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = findAllIndex(ar,target,0,list);
        System.out.println(ans);
        System.out.println(list);//the list and ans variable is pointing to the same object.That's why the value is same
        System.out.println(findAllIndex2(ar,target,0));
    }
    static boolean linearSearch(int[] arr,int target,int index){
        if (index==arr.length){
            return false;
        }
        return (arr[index]==target) || linearSearch(arr,target,index+1);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index,ArrayList<Integer> list){
        if (index==arr.length){
            return list;
        }
        if (arr[index]==target){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1,list);
    }
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index){
        //un optimize solution. cause the object list is created over and over
        ArrayList<Integer> list=new ArrayList<>();
        if (index==arr.length){
            return list;
        }
        if (arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr,target,index+1);
        if (!ansFromBelowCalls.isEmpty()){
            list.addAll(ansFromBelowCalls);
        }
        return list;
    }
}