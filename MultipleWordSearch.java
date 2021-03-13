/*
PROBLEM DESCRIPTION: Write a program that takes k words (call it target-words) from the command line, reads in a sequence of words from standard input, and identifies the smallest interval of text that contains all of the k words (not necessarily in the same order). We call such interval an match-interval, and we are looking to print the smallest such match-interval. You do not need to consider partial words. Any repeating words in command line should be ignored. If exists, output the smallest interval (the original text). If not such interval exists, the output should be empty.

DEPENDENCIES: StdIn.java

EXAMPLE 1:
Input:
	java MultipleWordSearch a b c
	d e a b d d c d b d d a d b
Output:
	a b d d c

EXAMPLE 2:
Input: 
	java MultipleWordSearch a b c
	a d b b c b b b b b b a c
Output:
  	b a c
*/

import java.util.*;

public class MultipleWordSearch
{
	public static final int NumChars = 256;
	public static String findSubstring(String str, String pat)
	{
		int len1 = str.length();
		int len2 = pat.length();

		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}
		
		int hashPat[] = new int[NumChars];
		int hashStr[] = new int[NumChars];

		for (int i = 0; i < len2; i++)
			hashPat[pat.charAt(i)]++;

		int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;

		int count = 0;
		for (int j = 0; j < len1; j++) {
			hashStr[str.charAt(j)]++;
			if (hashStr[str.charAt(j)] <= hashPat[str.charAt(j)])
				count++;
			if (count == len2) {
				while (hashStr[str.charAt(start)] > hashPat[str.charAt(start)] || hashPat[str.charAt(start)] == 0) {
					if (hashStr[str.charAt(start)] > hashPat[str.charAt(start)])
						hashStr[str.charAt(start)]--;
					start++;
				}
				int lenWindow = j - start + 1;
				if (minLen > lenWindow) {
					minLen = lenWindow;
					startIndex = start;
				}
			}
		}
		
		if ( startIndex == -1 ) {
			System.out.println("No such window exists");
			return "";
		}
		return str.substring(startIndex, startIndex + minLen);
	}

	public static void main(String[] args)
	{
		String pat = "";
		for (int i = 0; i < args.length; i++)
			pat += (args[i] + " ");
		String str = "";
		String[] input = StdIn.readAllStrings();

		for (int i = 0; i < input.length; i++)
			str += (input[i] + " ");
		System.out.print(findSubstring(str, pat));
	}
}
