/**PROBLEM DESCRIPTION: Develop a library based on the functions that we have considered in this bookfor computing properties of integers. Include functions for determining whethera given integer is prime; determining whether two integers are relatively prime;computing all the prime factors of a given integer(listed in ascending order); computing the greatest common divisor and least common multiple of twointegers; and the Euler’s totient function.
 * 
 * API:
 * 		public class IntegerProperty { 
 *	 		private IntegerProperty() {} // disallow creation of objects 
 * 			public static boolean isPrime(int x); // is prime? 
 * 			public static boolean isRelativePrime(int a, int b); 
 *	 		public static int[] factor(int x); // get all unique primes 
 * 			public static int gcd(int a, int b); // greatest common 
 * 			public static int lcm(int a, int b); // least common mul 
 *	 		public static int phi(int x); // Euler's totient function
 * 		}
 * 
 * Input: %java IntegerProperty 28405 15894
 * Ouput:
 * 		false 
 * 		false 
 * 		true 
 * 		5 13 19 23 
 * 		2 3 883 1 
 * 		451469070 
 * 		19008 
 * 		5292
 */

import java.util.*;
public class IntegerProperty
{
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(isPrime(a));
        System.out.println(isPrime(b));
        System.out.println(isRelativePrime(a, b));
        for (int f : factor(a)) System.out.print(f + " "); System.out.println();
        for (int f : factor(b)) System.out.print(f + " "); System.out.println();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
        System.out.println(phi(a));
        System.out.println(phi(b));
    }
    public static boolean isPrime(int x) // is prime?
    {
    	if (x <= 1) return false;
		if (x <= 3) return true;
		if (x % 2 == 0 || x % 3 == 0) return false;
		for (int i = 5; i*i <= x; i += 6)
			if (x % i == 0 || x % (i+2) == 0)
				return false;
		return true;
    }
    public static boolean isRelativePrime(int a, int b) // is relative prime?
    {
		for (int i = 2; i <= a; i++)
		{
			if ((a % i == 0) && (b % i == 0)) return  false;
		}
		return true;
    }
    public static int[] factor(int x) // get all factors
    {
        int[] a = new int[x / 2];
		int counter = 0;
		for (int i = 2; i <= x; i++) {
			if (x % i == 0) {
				boolean isPrime = true;
				for (int j = 2; j <= i / 2; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) { a[counter] = i; counter++; }
			}
		}
		int[] arr = new int[counter];
		for (int i = 0; i < counter; i++)
			arr[i] = a[i];
		return arr;
    }
    public static int gcd(int a, int b) // greatest common divisor
    {
		int t;
		while (b != 0) {
			t = a;
			a = b;
			b = t%b;
		}
		return a;
    }
    public static int lcm(int a, int b) // least common multiplier
    {
		if (a == 0 || b == 0) return 0;
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int lcm = max;
		while (lcm % min != 0)
			lcm += max;
		return lcm;
    }
    public static int phi(int x) // Euler's totient function
    {
        int result = 1;
		for (int i = 2; i < x; i++)
			if (gcd(i, x) == 1)
				result++;
		return result;
    }
}
