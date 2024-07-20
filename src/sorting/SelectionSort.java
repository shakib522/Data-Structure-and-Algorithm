package sorting;

import java.util.Arrays;

public class  SelectionSort{
    public static void main(String[] args) {
        int[] arr={6,4,2,1,0,3,3};
        int[] arr2={6,4,2,1,0,8,8,3};
        selectionSortUsingRecursion(arr,arr.length,0,0);
        selectionSort(arr2,arr2.length);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSortUsingRecursion(int[] arr,int r,int c,int max){
        if (r==0){
            return;
        }
        if (c<r){
            if (arr[c]>arr[max]) {
                selectionSortUsingRecursion(arr, r, c + 1, c);
            }else{
                selectionSortUsingRecursion(arr,r,c+1,max);
            }
        }else{
            int temp=arr[r-1];
            arr[r-1]=arr[max];
            arr[max]=temp;
            selectionSortUsingRecursion(arr,r-1,0,0);
        }
    }

    static void selectionSort(int[] arr,int n){
        int temp,index_min;
        for (int i=0;i<n-1;i++){
            index_min=i;
            for (int j=i+1;j<n;j++){
                if (arr[j]<arr[index_min]){
                    index_min=j;
                }
            }
            if (index_min!=i){
                temp=arr[i];
                arr[i]=arr[index_min];
                arr[index_min]=temp;
            }
        }
    }
}
