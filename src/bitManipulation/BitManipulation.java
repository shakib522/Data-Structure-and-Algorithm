package bitManipulation;

public class BitManipulation {
    public static void main(String[] args) {
        System.out.println(13<<1);
        BitManipulation bit = new BitManipulation();
        System.out.println(bit.convertDecimalToBinary(11));
        System.out.println(bit.convertBinaryToDecimal("1011"));

        System.out.println(bit.checkForSetBit(0, 13));
        System.out.println(bit.checkForSetBitUsingRightShift(0, 13));
        System.out.println(bit.setSpecificBit(2, 9));
        System.out.println(bit.unsetSpecificBit(2, 13));
        System.out.println("toggle: " + bit.toggleTheSpecificBit(2, 13));
        System.out.println("remove rightmost set bit: " + bit.removeRightMostSetBit(12));
        System.out.println("Is power of two : " + bit.isPowerOfTwo(13));
        System.out.println("Is power of two : " + bit.isPowerOfTwo(16));
        System.out.println("Count number of set bits : " + bit.countSetBits(12));
        System.out.println("Count number of set bits : " + bit.countSetBitsAnotherApproach(12));
    }

    int countSetBitsAnotherApproach(int n) {
        int cnt = 0;
        while (n != 0) {
            n = (n & (n - 1));
            cnt++;
        }
        return cnt;
    }

    int countSetBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n & 1; // n&1 return 1 if n is odd.and return 0 if n is even.because odd number always have 1 in the last bit and even number always have
            n = n >> 1; // n=n/2
        }
        return cnt;
    }

    boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }

    int removeRightMostSetBit(int num) {
        return num & (num - 1);
    }

    int toggleTheSpecificBit(int position, int num) {
        return num ^ (1 << position);
    }

    int unsetSpecificBit(int position, int num) {
        return (num) & (~(1 << position));
    }

    int setSpecificBit(int position, int num) {
        return (num | (1 << position));
    }

    boolean checkForSetBit(int bitPosition, int number) {
        //0 based
        if ((number & (1 << bitPosition)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkForSetBitUsingRightShift(int bitPosition, int number) {
        //0 based
        if (((number >> bitPosition) & 1) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String convertDecimalToBinary(int n) {
        //time complexity -> O(log n)
        //space complexity -> O(log n)
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 1) ans.append('1');
            else ans.append('0');
            n = n / 2;
        }
        return ans.reverse().toString();
    }

    public int convertBinaryToDecimal(String n) {
        // time complexity -> O(n)
        // space complexity -> O(1)
        int len = n.length();
        int p2 = 1, num = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                num += p2;
            }
            p2 *= 2;
        }
        return num;
    }
}

