package recursion.easy;

public class CountZero {
    public static void main(String[] args) {
        System.out.println( countZero(1000,0));
    }
    static int countZero(int num,int cnt){
        if (num==0){
            return cnt;
        }
        if(num%10==0){
            cnt++;
        }
        return countZero(num/10,cnt);
    }
}
