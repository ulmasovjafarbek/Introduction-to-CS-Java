/**PROBLEM DESCRIPTION: Given a sorted array of Comparable items, write function ceiling() that return theindex of the smallest item not smaller than an argument item in logarithmic timein the main function, take a standard input as an array, take a command-lineargument as the target, print the ceiling if there is no ceiling in the array.Otherwise, print no ceiling.
 * 
 * EXAMPLE:
 * Input: 7 12 21 25 32 37 47 51 52 60 60 68 69 76 79
 * Output: 32
 */

public class Ceiling {
    
    static int ceilSearch(int arr[], int target){
        int min = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] >= target)
            {
                if (min == 0) { min = arr[i]; }
                else {
                    min = Math.min(min, arr[i]);
                }
            }
        return min != 0 ? min : -1;
    } 
    public static void main(String[] args) {
        
        int[] arr = StdIn.readAllInts();
        
        int target =Integer.parseInt(args[0]);
	    int r = ceilSearch(arr, target);
        if (r!=-1) 
            System.out.println(r);
        else System.out.println("no ceiling");
    }
}
