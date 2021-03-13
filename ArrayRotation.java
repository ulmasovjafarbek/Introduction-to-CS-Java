/**PROBLEM DESCRIPTION: Array rotation. Given an array of n elements, give a linear-time algorithm torotate the string k positions. Use at most a constant amount of extra memory. Follow these steps:
 * 1. Reverse the whole array (1 revserse)
   2. Divide the whole in two parts based on k and reverse each partseparately (2 reverses)
 * 
 * Input: %java ArrayRotation 7
 *         1 2 3 4 5 6 7 8 9 0
 * Output: 8 9 0 1 2 3 4 5 6 7
 */

public class ArrayRotation
{
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int [] a = StdIn.readAllInts();
        a = rotate(a, k);
        for (int i=0;i<a.length;i++)
            System.out.print( a[i]+ ((i==a.length-1)?"\n":" " ));
    }
    
    public static int[] reverse(int[] a, int i, int j){
        while (i < j) {
            int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            i++;
            j--;
        } return a;
    }
    public static int[] rotate(int[] nums, int k) {
        k%=nums.length;
        int l = nums.length;
        nums = reverse(nums, 0, l-1);
        nums = reverse(nums, 0, l - k-1);
        nums = reverse(nums, l-k, l-1);
        return nums;
    }
}
