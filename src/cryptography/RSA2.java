package cryptography;

import javax.management.ObjectName;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter the number to be encrypted and decrypted: ");
        BigInteger m = sc.nextBigInteger();

        System.out.print("Enter first prime number: ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter second prime number: ");
        BigInteger q = sc.nextBigInteger();

        // Compute n and phi
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Choose e such that 1 < e < phi and gcd(e, phi) = 1
        BigInteger e = BigInteger.TWO;
        while (e.compareTo(phi) < 0) {
            if (e.gcd(phi).equals(BigInteger.ONE)) {
                break;
            }
            e = e.add(BigInteger.ONE);
        }

        // Find d such that (d * e) mod phi = 1
        BigInteger d = e.modInverse(phi);

        // Output the results
        System.out.println("The value of n = " + n);
        System.out.println("The value of phi = " + phi);
        System.out.println("The value of e = " + e);
        System.out.println("The value of d = " + d);
        System.out.println("Public encryption key = (" + e + ", " + n + ")");
        System.out.println("Private decryption key = (" + d + ", " + n + ")");

        // Ciphertext c = (m^e) mod n
        BigInteger cipher = m.modPow(e, n);
        System.out.println("Encrypted Ciphertext: " + cipher);

        // Plaintext m = (c^d) mod n
        BigInteger plain = cipher.modPow(d, n);
        System.out.println("Decrypted Plaintext: " + plain);

        sc.close();
    }
}
