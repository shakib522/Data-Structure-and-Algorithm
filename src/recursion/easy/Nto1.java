package recursion.easy;

public class Nto1 {
    public static void main(String[] args) {
        System.out.println("Normal: ");
        fun(5);
        System.out.println("Reverse: ");
        funReverse(5);

        System.out.println("Fun Both");
        funBoth(5);
    }
    static void funReverse(int n){
        if (n==0){
            return;
        }
        fun(n-1);
        System.out.println(n);
    }
    static void fun(int n){
        if (n==0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }
    static void funBoth(int n){
        if (n==0){
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}
