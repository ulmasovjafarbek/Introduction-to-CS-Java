/**PROBLEM DESCRIPTION: Write a program that takes a command-line argument n (n <= 2and returns the value of i < n for which the number of recurfor collatz(i) is maximized. You should make use of memorizamodifying the above procedure. In fact, this problem is also the simpliest form of dynamic programming, that you need to for each number less than n.
 * 
 * Input: %java Collatz 8
 * Output: 7
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class Collatz
{
	public static final Map<Integer,Integer> previousResults = new HashMap<>();
	private static int collatz(int n) {
		int result = 1;
		if (previousResults.containsKey(n)) {
			return previousResults.get(n);
		} else {
			if (n==1) result = 1;
			else if (n%2==0) result+= collatz(n/2);
			else result += collatz(3*n + 1);
			previousResults.put(n, result);
			return result;
		}
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int maxn = 0, maxSize = 0;
		for (int n = N; n > 0; n--) {
			int size = collatz(n);
			if (size > maxSize) {
				maxn = n;
				maxSize = size;
			}
		}
		System.out.println(maxn);
	}
}
