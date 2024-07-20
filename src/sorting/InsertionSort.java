package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array={4,6,2,3,5,8};
        insertionSort(array,array.length);
        System.out.println(Arrays.toString(array));
    }
    static void insertionSort(int[] array,int n){
        int i,j,item;
        for (i=1;i<n;i++){
            item=array[i];
            j = i-1;
            while (j>=0 && array[j]>item){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=item;
        }
    }
}