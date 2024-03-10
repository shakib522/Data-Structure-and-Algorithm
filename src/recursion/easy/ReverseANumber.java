package recursion.easy;

public class ReverseANumber {
    public static void main(String[] args) {
        int num=35419;
        int len=findLen(num);
        int n=1;
        for (int i=1;i<len;i++) {
            n *= 10;
        }
        System.out.println( reversing(num,n));
    }
    static int reversing(int number,int whichMultiply){
        if(number<10){
            return number;
        }
        return ((number%10)*whichMultiply)+reversing(number/10, whichMultiply/10);
    }
    static int findLen(int number){
        if (number<10){
            return 1;
        }
        return 1+findLen(number/10);
    }
}