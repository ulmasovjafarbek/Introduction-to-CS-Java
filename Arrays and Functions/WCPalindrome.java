/**PROBLEM DESCRIPTION: Write a function isWatsonCrickPalindrome() that takes a DNA string as its inputand returns true if the string is a Watson–Crick complemented palindrome, andfalse otherwise. A Watson–Crick complemented palindrome is a DNA string thatis equal to the reverse of its Watson–Crick complement.
 * Input: java WCPalindrome ATAGATA
 * Output: false
 * Input: java WCPalindrome AT
 * Output: true
 */

import java.util.Arrays;
public class WCPalindrome
{
    public static void main(String[] args) {
        System.out.println(isWatsonCrickPalindrome(args[0]));        
        return;
    }
    public static boolean isWatsonCrickPalindrome(String sequence) {
        if (sequence.equals(reverse(complementWatsonCrick(sequence)))) return true;
        return false;
    }
    public static String complementWatsonCrick(String s)
    {
    	s = s.replaceAll("A", "a");
        s = s.replaceAll("T", "A");
        s = s.replaceAll("a", "T");
        s = s.replaceAll("C", "c");
        s = s.replaceAll("G", "C");
        s = s.replaceAll("c", "G");
        return s;
    }
    public static String reverse(String s)
    {
    	char[] r = s.toCharArray();
        s = "";
        for (int i = r.length-1; i >= 0; i--)
            s += r[i];
        return s;
    }
}
