package cryptography;

import java.util.Arrays;

public class SDES {

    private static final int[] P10 = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    private static final int[] P8 = {6, 3, 7, 4, 8, 5, 10, 9};
    private static final int[] P4 = {2, 4, 3, 1};
    private static final int[] IP = {2, 6, 3, 1, 4, 8, 5, 7};
    private static final int[] IP_INV = {4, 1, 3, 5, 7, 2, 8, 6};
    private static final int[] EP = {4, 1, 2, 3, 2, 3, 4, 1};
    private static final int[] key = {1, 0, 1, 0, 0, 0, 0, 0, 1, 0};
    int[] key1 = new int[8];
    int[] key2 = new int[8];
    int[][] s0 = {
            {1, 0, 3, 2},
            {3, 2, 1, 0},
            {0, 2, 1, 3},
            {3, 1, 3, 2}
    };
    int[][] s1 = {
            {0, 1, 2, 3},
            {2, 0, 1, 3},
            {3, 0, 1, 0},
            {2, 1, 0, 3}
    };

    int[] permutation(int[] ara, int[] permArray) {
        int[] newAra = new int[permArray.length];
        for (int i = 0; i < permArray.length; i++) {
            newAra[i] = ara[permArray[i] - 1];
        }
        return newAra;
    }

    void keyGeneration() {
        int[] key_ = permutation(key, P10);
        int[] ls = new int[5];
        int[] rs = new int[5];
        for (int i = 0; i < 5; i++) {
            ls[i] = key_[i];
            rs[i] = key_[i + 5];
        }

        int[] ls_1 = shift(ls, 1);
        int[] rs_1 = shift(rs, 1);

        for (int i = 0; i < 5; i++) {
            key_[i] = ls_1[i];
            key_[i + 5] = rs_1[i];
        }
        key1 = permutation(key_, P8);
        int[] ls_2 = shift(ls, 2);
        int[] rs_2 = shift(rs, 2);
        for (int i = 0; i < 5; i++) {
            key_[i] = ls_2[i];
            key_[i + 5] = rs_2[i];
        }
        key2 = permutation(key_, P8);

        System.out.println("Your key-1: ");
        System.out.println(Arrays.toString(key1));
        System.out.println("Your key-2: ");
        System.out.println(Arrays.toString(key2));
    }

    int[] shift(int[] ar, int n) {
        while (n > 0) {
            int temp = ar[0];
            for (int i = 0; i < ar.length - 1; i++) {
                ar[i] = ar[i + 1];
            }
            ar[ar.length - 1] = temp;
            n--;
        }
        return ar;
    }

    int[] encryption(int[] plaintext) {
        int[] arr = permutation(plaintext, IP);
        int[] arr1 = function_(arr, key1);
        int[] after_swap = swap(arr1, arr1.length / 2);
        int[] arr2 = function_(after_swap, key2);
        int[] cipherText = permutation(arr2, IP_INV);
        return cipherText;
    }

    int[] decryption(int[] cipher) {
        int[] arr = permutation(cipher, IP);
        int[] arr1 = function_(arr, key2);
        int[] after_swap = swap(arr1, arr1.length / 2);
        int[] arr2 = function_(after_swap, key1);
        int[] decrypted = permutation(arr2, IP_INV);
        return decrypted;
    }

    int[] function_(int[] ar, int[] key) {
        int[] l = new int[4];
        int[] r = new int[4];
        for (int i = 0; i < 4; i++) {
            l[i] = ar[i];
            r[i] = ar[i + 4];
        }
        int[] ep = permutation(r, EP);
        for (int i = 0; i < 8; i++) {
            ar[i] = key[i] ^ ep[i];
        }
        int[] l1 = new int[4];
        int[] r1 = new int[4];
        for (int i = 0; i < 4; i++) {
            l1[i] = ar[i];
            r1[i] = ar[i + 4];
        }
        int row, col, val;
        row = Integer.parseInt("" + l1[0] + l1[3], 2);//convert binary to decimal
        col = Integer.parseInt("" + l1[1] + l1[2], 2);//convert binary to decimal
        val = s0[row][col];
        String str_l = decimalToBinary(val);
        row = Integer.parseInt("" + r1[0] + r1[3], 2);
        col = Integer.parseInt("" + r1[1] + r1[2], 2);//binary to decimal
        val = s1[row][col];

        String str_r = decimalToBinary(val);
        int[] combine = new int[4];
        for (int i = 0; i < 2; i++) {
            char c1 = str_l.charAt(i);
            char c2 = str_r.charAt(i);
            combine[i] = Character.getNumericValue(c1);
            combine[i + 2] = Character.getNumericValue(c2);
        }
        int[] combine_p4 = permutation(combine, P4);
        for (int i = 0; i < 4; i++) {
            l[i] = l[i] ^ combine_p4[i];
        }
        int[] output = new int[8];
        concatArrayEquality(l, r, output);
        return output;
    }

    void concatArrayEquality(int[] a1, int[] a2, int[] output) {
        int len = a1.length;
        for (int i = 0; i < len; i++) {
            output[i] = a1[i];
            output[i + len] = a2[i];
        }
    }

    int[] swap(int[] array, int n) {
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = array[i];
            r[i] = array[i + n];
        }
        int[] output = new int[2 * n];
        for (int i = 0; i < n; i++) {
            output[i] = r[i];
            output[i + n] = l[i];
        }
        return output;
    }

    String decimalToBinary(int val) {
        if (val == 0)
            return "00";
        else if (val == 1)
            return "01";
        else if (val == 2)
            return "10";
        else
            return "11";
    }

    public static void main(String[] args) {
        SDES sdes = new SDES();
        sdes.keyGeneration();
        int[] plainText = {1, 0, 0, 1, 0, 1, 0, 1};
        System.out.println("plain text:");
        System.out.println(Arrays.toString(plainText));
        System.out.println("cipher text");
        int[] cipherText = sdes.encryption(plainText);
        System.out.println(Arrays.toString(cipherText));
        System.out.println("Decrypted text: ");
        System.out.println(Arrays.toString(sdes.decryption(cipherText)));

    }

}

