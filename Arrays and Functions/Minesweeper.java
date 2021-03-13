/**PROBLEM DESCRIPTION: Minesweeper: generate numbered mine fields You will need to get two integer command-line parameter n and m (1 <= n, m <=50), and then read a n * m grid from standard input. The grid will only contains two type of character, stars (mine) and dashes (emptyspace). Your task is to compute the number of mines in the eight block near thecurrent block for the whole grid, just like the original Minesweeper game(put 0 ifthe block is a mine).
 * 
 * Input: %java Minesweeper 5 17
 *      * - - * * * * * * * * - * - * - -
 *      * - * - * * - * - * * - * * * * * 
 *      - - - * * * * - * - - * - * * * * 
 *      * * - - * * * - - - * * - * * * * 
 *      * * * - * * * - * * - - * * * * *
 * Output:
 *      1 3 2 3 4 4 4 3 4 4 3 4 2 5 3 4 2
        1 3 2 6 7 7 7 5 6 5 4 5 4 6 6 6 3
        3 4 3 4 6 7 5 4 2 4 5 4 6 6 8 8 5
        3 4 4 5 6 8 5 5 3 4 3 3 6 6 8 8 5
        3 4 2 3 3 5 3 3 1 2 3 3 3 4 5 5 3
 */

public class Minesweeper
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]), m = Integer.parseInt(args[1]);
        boolean[][] mineField = new boolean[n+2][m+2];
        int[][] value = new int[n+2][m+2];
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
            {
                char ch = ' ';
                while (ch == ' ' || ch == '\n') ch = StdIn.readChar();
                if (ch == '*') mineField[i][j] = true;
                else mineField[i][j] = false;
            }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                for (int ii = i - 1; ii <= i + 1; ii++)
                    for (int jj = j - 1; jj <= j + 1; jj++)
                        if (mineField[ii][jj]) value[i][j]++;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
            {
                if (mineField[i][j]) System.out.print((value[i][j]-1));
                else System.out.print(value[i][j]);

                if (j == m) StdOut.println();
                else StdOut.print(" ");
    	    }
        return;
    }
}
