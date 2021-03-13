/*
PROBLEM DESCRIPTION: A concordance is an alphabetical list of words in a text that gives all wordpositions where each words appear (start from 1). Write a programInvertConcordance that takes a command-line positive integer n, and read aconcordance from standard input, then prints the first n words of the text.
	Note:
	1. The corcordance’s format is of many lines, each line contains a word (withoutwhitespace) and a space-split positive number list (guaranteed to be sortedfrom small to large).
	2. All the indexes are guaranteed to be non-replicating and their junction formsa permutation of 1-k (k>=n).

DEPENDENCIES: ST.java

EXAMPLE:
Input:
	nyp 25 
	y 22 33 
	wa 8 
	zl 7 
	dcw 13 
	qqn 21
	crp 34 
	zg 24 
	yy 16 
	pec 2 
	t 17 31 
	j 35 44 
	g 1 
	v 18 
	pql 6 
	s 14 37 
	qkb 30 
	bm 9 
	bto 29 
	quo 32 
	gsc 36 
	o 15 
	d 5 
	k 27 
	cru 3 
	a 41 
	nae 43 
	n 12 
	q 11 19 
	z 26 28 38 40 
	icm 23 
	lr 4 
	jvx 39 
	joi 42 
	hgz 20 
	ben 10
Output:
	g pec cru lr d pql zl
*/

public class InvertConcordance
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);

		String[] database = StdIn.readAllLines();
		ST<Integer, String> map = new ST<Integer, String>();

		for (int i = 0; i < database.length; i++) {
			String[] tokens = database[i].split(" ");
			String val = tokens[0];
			for (int j = 1; j < tokens.length; j++) {
				int key = Integer.parseInt(tokens[j]);
				map.put(key, val);
			}	
		}
		
		for (int i = 1; i <= n; i++) {
			if (map.contains(i)) StdOut.print(map.get(i) + " ");
		}

		return;
    }
}
