/*
PROBLEM DESCRIPTION: Write a Java RE to match all words that contain the five vowels (a, e, i, o, u) inorder, and no other vowels (e.g., abstemious and facetious). The input argumentin the command line is the word and the output is Yes if the word matches therequirement and No on the contrary.

EXAMPLE:
Input:
    java VowelsInOrder abstemious
Output:
    Yes
*/

public class VowelsInOrder
{
    public static void main(String[] args) { 
        String arg = args[0];
        String regexp = "^[^aeiou]*a[^aeiou]*e[^aeiou]*i[^aeiou]*o[^aeiou]*u[^aeiou]*$";
        if (arg.matches(regexp))
            System.out.println("Yes");
        else System.out.println("No");
    }
}
