package recursion.easy;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] ar = {5,6,7,8,9,1,2,3};
        int index = search(ar, 2, 0, ar.length - 1);
        System.out.println(index);
    }

    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m - 1);
            } else {
                return search(arr, target, m + 1, e);
            }
        }
        if (target >= arr[m] && target <= arr[e]) {
            return search(arr, target, m + 1, e);
        }
        return search(arr, target, s, m - 1);
    }
}