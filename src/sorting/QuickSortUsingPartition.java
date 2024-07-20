package sorting;

import java.util.Arrays;

public class QuickSortUsingPartition {
    public static void main(String[] args) {
        int[] ara = {5,7,1,3,9,2,55,55,110};
        quickSort(ara,0,ara.length-1);
        System.out.println(Arrays.toString(ara));
    }

    static void quickSort(int[] ara,int low,int high){
        if (low>=high){
            return;
        }
        int p=partition(ara,low,high);
        quickSort(ara,low,p-1);
        quickSort(ara,p+1,high);
    }
    static int partition(int[] ara,int start,int end){
        int position=start-1;
        int pivot=ara[end];//select pivot from the last index of the array
        for (int i=start;i<end;i++){
            if (ara[i]<pivot){
                position++;
                swap(ara,position,i);
            }
        }
        swap(ara,position+1,end);
        return position+1;
    }
    static void swap(int[] ara,int first,int second){
        int temp=ara[first];
        ara[first]=ara[second];
        ara[second]=temp;
    }
}
