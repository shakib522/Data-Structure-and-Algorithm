package recursion.easy;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(21));
    }
    static int reversing(int number,int multiply){
        if(number<10){
            return number;
        }
        return ((number%10)*multiply)+reversing(number/10, multiply/10);
    }
    static boolean palindrome(int n){
        return n==reversing(n,(int) Math.pow(10,(int) Math.log10(n)));
    }
}
