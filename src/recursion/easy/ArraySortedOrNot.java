package recursion.easy;

public class ArraySortedOrNot {
    public static void main(String[] args) {
        int [] ar={1,3,5,8,5,10};
        System.out.println(sortedOrNot(ar,0));
    }
    static boolean sortedOrNot(int [] array,int index){
        if (index==array.length-1){
            return true;
        }
        return array[index] <= array[index+1] && sortedOrNot(array,index+1);
    }
}