package recursion;

public class Fibonacchi {
    public static void main(String[] args) {
        System.out.println(fibo(6));
    }
    static int fibo(int n){
        //function for find nth fibonacchi number
        if (n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
}
