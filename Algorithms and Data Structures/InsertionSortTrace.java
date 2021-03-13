/* PROGRAM DESCRIPTION: Write a program that traces how insertion sort works
 * 
 * EXAMPLE:
 * Input:
 * 		was had him and you his the but
 * Output:
 * 		was had him and you his the but 
 * 		had was him and you his the but
 * 		had him was and you his the but 
 * 		and had him was you his the but 
 * 		and had him was you his the but 
 * 		and had him his was you the but 
 * 		and had him his the was you but 
 * 		and but had him his the was you
 */

public class InsertionSortTrace
{
	public static void printArrayOf(String[] a)
	{
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	public static void sort(String[] a)
	{
		int n = a.length;
		printArrayOf(a);
		for (int i = 1; i < n; i++)
		{
			for (int j = i; j > 0; j--)
				if (a[j].compareTo(a[j-1]) < 0)
					exchange(a, j-1, j);
				else break;
			printArrayOf(a);
		}
	}
	public static void exchange(String[] a, int i, int j)
	{
		String temp = a[j]; a[j] = a[i]; a[i] = temp;
	}
	public static void main(String[] args)
	{
		String[] a = StdIn.readAllStrings();
		sort(a);
	}
}

