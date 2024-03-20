package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {1,5,7,23,2};
        bubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] array,int r,int c){
        if (r==0){
            return;
        }
        if (c<r){
            if (array[c]>array[c+1]){
                int temp=array[c];
                array[c]=array[c+1];
                array[c+1]=temp;
            }
            bubbleSort(array,r,c+1);
        }else{
            bubbleSort(array,r-1,0);
        }
    }
}
