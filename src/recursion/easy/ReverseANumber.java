package recursion.easy;

public class ReverseANumber {
    public static void main(String[] args) {
        int num=1049;
//        int len=(int) Math.log10(num);
//        int n=(int) Math.pow(10,len);
        System.out.println( reversing(num,(int) Math.pow(10,(int) Math.log10(num))));
    }
    static int reversing(int number,int multiply){
        if(number<10){
            return number;
        }
        return ((number%10)*multiply)+reversing(number/10, multiply/10);
    }
    static int findLen(int number){
        if (number<10){
            return 1;
        }
        return 1+findLen(number/10);
    }
}