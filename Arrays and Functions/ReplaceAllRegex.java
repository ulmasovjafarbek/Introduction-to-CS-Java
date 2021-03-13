/*
PROBLEM DESCRIPTION: Write a filter SearchAndReplace.java that takes an RE,a string str and a string input from standard input, replaces all substrings on input that match the RE with str, and sends the results to standard output. Solve it without using replaceAll() method in Java’s String. Note: This uses Pattern and Matcher class. This is replace all, so we need to iterate through all matches.

EXAMPLE:
Input:
    java ReplaceAll
    [0-9]*a{2}
    "o"
    1aaapaapap0aaa
Output:
    "o"ap"o"pap"o"a
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ReplaceAll {
    
    public static void main(String[] args) {

        String regexp = StdIn.readLine();
        String str = StdIn.readLine();
        String input = StdIn.readLine();
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);

        StdOut.println(matcher.replaceAll(str));
    }
}
