/**PROBLEM DESCRIPTION: Given an array of n real numbers, design a linearithmic-time algorithm to find apair of integers that are closest in value. And print out the the pair that has thesmallest value.
 * 
 * EXAMPLE:
 * Input: 16 40 8 31 34 19 2 11 49 4 6
 * Output: 2 4
 */

import java.util.Arrays;
public class ClosestPair {
    static int [] findclosestPair(int[] arr) {
		int shortest = arr[1] - arr[0];
		int a = arr[0], b = arr[1];
		for (int i = 2; i < arr.length; i++) {
			if (shortest > arr[i] - arr[i-1])
			{
				shortest = arr[i] - arr[i-1];
				a = arr[i-1]; b = arr[i];
			}
		}
		int[] found_pair = new int[]{a, b};
		return found_pair;
    }
    public static void sort(int[] a)
    {
		int[] aux = new int[a.length];
    	sort(a, aux, 0, a.length);
    }
    public static void sort(int[] a, int[] aux, int lo, int hi)
    {
    	if (hi - lo <= 1) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid, hi);
		int i = lo, j = mid;
		for (int k = lo; k < hi; k++)
		{
			if (i == mid) aux[k] = a[j++];
			else if (j == hi) aux[k] = a[i++];
			else if (compare(a[j], a[i]) < 0) aux[k] = a[j++];
			else aux[k] = a[i++];
		}
		for (int k = lo; k < hi; k++)
			a[k] = aux[k];
    }
    public static int compare(int a, int b)
    {
    	return a < b ? -1 : 1;
    }
    public static void main(String[] args) {
        int[] arr = StdIn.readAllInts();
		sort(arr);
        int [] found_pair = findclosestPair(arr);
        System.out.println( found_pair[0] + " " + found_pair[1]);
    }

}
