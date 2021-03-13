/**PROBLEM DESCRIPTION: Given an array of n real numbers, design a logarithmic-time algorithm to identifya local minimum (an index i such that both a[i] < a[i-1] and a[i] < a[i+1]) in yourmain function, take standard input as an array, call the method and print theindex of the local minimum. For corner elements, we need to consider only one neighbor for comparison.There can be more than one local minima in an array, we need to find any one ofthem. Following corner cases give better idea about the problem.
 * 
 * EXAMPLE:
 * Input: 259 -8470 383 6573 -5252 627 -6766 7850 -5382 -4475 -9155 57
 * Output: 1
 */

public class LocalMinimum {
    public static int localMinima_r(int[] arr, int low, int high, int n){
        int mid = low + (high - low) / 2;
        if ((mid == 0 || arr[mid-1] > arr[mid]) && (mid == n-1 || arr[mid+1] > arr[mid]))
            return mid;
        else if (mid > 0 && arr[mid - 1] < arr[mid])
            return localMinima_r(arr, low, mid - 1, n);
        return localMinima_r(arr, mid + 1, high, n);
    }
    public static int localMinima_r(int[] arr, int low, int n)
    {
    	return localMinima_r(arr, low, n - 1, n);
    }
    public static void main(String[] args) {
        int arr[] = StdIn.readAllInts();
        int n = arr.length;
        System.out.println(localMinima_r(arr, 0, n));
    }
}
