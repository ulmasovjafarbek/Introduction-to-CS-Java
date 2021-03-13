/*
PROBLEM DESCRIPTION: Develop a program that counts the number of substrings in standard input thatmatch the RE, without worrying about overlapping matches (use Pattern andMatcher) The standard input should be the RE and the test string and the outputshould be the number of substrings that match the RE.

EXAMPLE:
Input:
    java CountMatches 
    [ab][cd] 
    abbcde12adbc
Output:
    3
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CountMatches {
    public static void main(String[] args) { 
        
        String regexp = StdIn.readLine();
        String input = StdIn.readString();
	    Pattern pattern = Pattern.compile(regexp);
        Matcher countMatch = pattern.matcher(input);

	    long count = countMatch.results().count();
        StdOut.println(count);
    }
    
}
