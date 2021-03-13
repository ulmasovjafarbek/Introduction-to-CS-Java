/* PROBLEM DESCRIPTION: Write a program that uses MergeSort algorithm to sort the array
 * 
 * EXAMPLE:
 * Input:
 * 		28 50 32 47 14 18 6 48 23
 * Ouput:
 * 		OriginalArray:[28, 50, 32, 47, 14, 18, 6, 48, 23]
 *		SortedArray:[6, 14, 18, 23, 28, 32, 47, 48, 50]
 */

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] a) {
    	int low = 0;
		int high = a.length - 1;

		int[] temp = Arrays.copyOf(a, a.length);

		for (int m = 1; m <= high - low; m = 2*m)
		{
			for (int i = low; i < high; i += 2*m)
			{
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2*m - 1, high); // line 21
				merge(a, temp, from, mid, to);
			}
		}	
    }
    public static void merge(int[] a, int[] temp, int from, int mid, int to) {
    	int k = from, i = from, j = mid + 1;
		while (i <= mid && j <= to) {
			if (a[i] < a[j]) temp[k++] = a[i++];
			else temp[k++] = a[j++];
		}
		while (i <= mid) {
			temp[k++] = a[i++]; // line 38
		}
		for (i = from; i <= to; i++)
			a[i] = temp[i];
	}
    public static void main(String args[]) {
        int[] arr = StdIn.readAllInts();
        System.out.println("OriginalArray:" + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("SortedArray:" + Arrays.toString(arr));
    }
    
}
