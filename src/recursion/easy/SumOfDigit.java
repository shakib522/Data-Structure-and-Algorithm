package recursion.easy;

public class SumOfDigit {
    public static void main(String[] args) {
        System.out.println(sumOfDigit(344));
    }

    static int sumOfDigit(int number){
        if (number<9){
            return number;
        }
        return (number%10)+sumOfDigit(number/10);
    }
}
