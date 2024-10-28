package cryptography;

import java.math.BigInteger;
import java.util.Scanner;

public class RSA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be encrypted and decrypted");
        BigInteger m = scanner.nextBigInteger();
        System.out.println("Enter first prime number: ");
        BigInteger p = scanner.nextBigInteger();
        System.out.println("Enter second prime number: ");
        BigInteger q = scanner.nextBigInteger();
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.TWO;
        while (e.compareTo(phi)<0){
            if (e.gcd(phi).equals(BigInteger.ONE)){
                break;
            }
            e=e.add(BigInteger.ONE);
        }
        BigInteger d = e.modInverse(phi);

        System.out.println("The value of n = "+n);
        System.out.println("The value of phi = "+phi);
        System.out.println("The value of e = "+e);
        System.out.println("The value of d = "+d);
        System.out.println("Public key: {e,n} = { " +e+", "+n+" } ");
        System.out.println("private key: {d,n} = { " +d+", "+n+" } ");
        BigInteger cipher = m.modPow(e,n);
        System.out.println("Encrypted cipher text: "+cipher);

        BigInteger plain = cipher.modPow(d,n);
        System.out.println("Decrypted plain text: "+plain);
    }
}
