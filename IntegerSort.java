/**PROBLEM DESCRIPTION: Write a linear-time filter that reads from standard input a sequence of integersthat are between 0 and 99 and prints to standard output the same integers insorted order.
 * 
 * EXAMPLE:
 * Input: 4 6 23 22 31 18 28
 * Output: 4 6 18 22 23 28 31
 */

import java.util.Arrays;
public class IntegerSort{
	public static int[] sort(int[] nums, int maxValue)
	{
		int[] Bucket = new int[maxValue + 1];
		int[] sortedNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			Bucket[nums[i]]++;
		}
		int outPos = 0;
		for (int i = 0; i < Bucket.length; i++)
			for (int j = 0; j < Bucket[i]; j++)
				sortedNums[outPos++] = i;
		return sortedNums;
	}
	public static int maxValue(int[] nums)
	{
		int maxValue = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] > maxValue)
				maxValue = nums[i];
		return maxValue;
	}

    public static void main(String[] args) {
        
        int[] arr = StdIn.readAllInts();
        int maxValue = maxValue(arr);
        arr = sort(arr, maxValue);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
