package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 4, 2};
        int[] array = {10, 10, 1, 9, 7, 4, 2};
        bubbleSortUsingRecursion(arr, arr.length - 1, 0);
        System.out.println("Bubble sort using recursion: ");
        System.out.println(Arrays.toString(arr));
        bubbleSort(array, array.length);
        System.out.println("Bubble sort without recursion: ");
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSortUsingRecursion(int[] array, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (array[c] > array[c + 1]) {
                int temp = array[c];
                array[c] = array[c + 1];
                array[c + 1] = temp;
            }
            bubbleSortUsingRecursion(array, r, c + 1);
        } else {
            bubbleSortUsingRecursion(array, r - 1, 0);
        }
    }

    static void bubbleSort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
