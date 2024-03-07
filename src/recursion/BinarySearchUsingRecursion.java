
package recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] array ={0,1,3,7,10,11,13,18,22,26,29,30,32,35,38,40};
        int target=13;
        System.out.println(search(array,target,0,array.length-1));
    }

    static int search(int[] arr,int target,int s,int e){
        if (s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(arr[m]<target){
            return search(arr,target,m+1,e);
        }
        return search(arr,target,s,m-1);
    }
}
