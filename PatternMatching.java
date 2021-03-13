/* PROBLEM DESCRIPTION: Pattern matching. Given an n-by-n subarray of black (1) and white (0) pixels,design a linear-time algorithm that finds the largest square subarray thatcontains no white pixels.
 * 
 * DEPENDENCIES: StdIn.java
 * 
 * EXAMPLE:
 * Input:
 * 		java PatternMatching
 * 		1 1 1 1 1 1 1 1 0 1 1 0 1 1 0 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1
		1 1 0 0 0 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 0 1
		1 1 1 1 1 1 0 1 1 1 0 1 1 1 1 1 1 0 1 0 1 1
		1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 0 1 1
		1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 0 1 1 1 1 0
		1 1 1 0 1 1 0 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1
		0 1 1 1 0 0 0 0 1 1 0 0 1 1 1 1 0 1 1 0 1 1
		1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 0 1 1
		1 1 0 1 1 1 1 1 0 1 1 1 1 0 1 1 1 0 1 0 1 1
		1 1 1 1 1 1 1 1 1 1 1 0 1 1 0 1 1 0 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1
		0 1 1 1 1 1 1 1 1 1 0 1 1 0 1 1 1 1 0 1 0 1
		1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
		1 1 1 0 1 1 0 1 1 1 1 1 1 0 1 0 1 1 1 1 1 0
		1 1 1 1 1 0 1 0 1 1 1 1 0 1 1 1 1 0 1 1 1 0
		1 1 1 0 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1
		1 1 1 0 0 1 1 1 1 1 0 1 1 0 1 0 1 1 0 1 1 1
		1 1 1 0 1 1 1 1 1 1 0 1 1 1 1 0 0 1 0 0 1 1
		1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1
		1 1 1 0 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1 1 1
		1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1
 *  Output:
 * 		The largest black pixel squares have side length: 5
 		 And the most top-left of them begins at index coordinate: (8, 3)
 */

public class PatternMatching {

	public static void printMaxSubSquare(int arr[][])
	{
		int i, j;
		int row = arr.length;
		int column = arr[0].length;
		int subArr[][] = new int[row][column];

		int maxSubArr, maxI, maxJ;

		for (i = 0; i < row; i++)
			subArr[i][0] = arr[i][0];

		for (j = 0; j < column; j++)
			subArr[0][j] = arr[0][j];

		for (i = 1; i < row; i++)
		{
			for (j = 1; j < column; j++) {
				if (arr[i][j] == 1)
					subArr[i][j] = Math.min(subArr[i][j-1], Math.min(subArr[i-1][j], subArr[i-1][j-1])) + 1;
				else subArr[i][j] = 0;
			}
		}

		maxSubArr = subArr[0][0]; maxI = 0; maxJ = 0;
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				if (maxSubArr < subArr[i][j])
				{
					maxSubArr = subArr[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}

		System.out.println("The largest black pixel squares have side length: " + maxSubArr);
		System.out.println(" And the most top-left of them begins at index coordinate: (" + (maxI - maxSubArr + 1) + ", " + (maxJ - maxSubArr + 1) + ")");
	}

    public static void main(String[] args) {
        
        int [] raw = StdIn.readAllInts();
        int n = (int)Math.sqrt(raw.length);
        int [][] A = new int [n][n];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                A [i][j] = raw[i*n+j];
            }
        }
  
		printMaxSubSquare(A);
    }
}
