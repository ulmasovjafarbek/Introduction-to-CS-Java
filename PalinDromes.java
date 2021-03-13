/* 
PROBLEM DESCRIPTION: Write a Java program that solves the recognition problem for palindromes, taking a sequence of input strings from standard input. For simplicity, assume that the underlying alphabet is Roman. Specifically, for each string on standard input your program should print the string followed by “is a palindrome” if the string is a palindrome and “is not a palindrome” if it is not.

DEPENDENCIES: StdIn.java, StdOut.java

EXAMPLE:
Input:
    java PalinDromes abaaba
Output:
    abaaba is a palindrome

*/

import java.util.Stack;

public class PalinDromes
{
    public static void main(String[] args) {
        String arg = args[0];
        if (isPalinDrome(arg)){
            StdOut.println(arg+" is a palindrome");
        }
        else {
            StdOut.println(arg+" is not a palindrome");
        }
    }

    private static boolean isPalinDrome(String s){
    	Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        String reverse = "";

        for (int i = 0; i < s.length(); i++) {
            reverse += stack.pop();
        }

        if (s.equals(reverse))
            return true;
        else return false;

    }
}
