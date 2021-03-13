/**PROBLEM DESCRIPTION: Write a program Combinations that takes an integer command-line argument nand prints all combinations of any size. A combination is a subset of the n elements, independent of order.
 *      Note that your program needs to print the empty string (subset of size 0). In this case, you are given an array of 26 English letters, you are asked to printout the combination of first N letters, where N is the command line arguments.
 * 
 * Input: %java Combination 3
 * Output: a ab abc ac b bc c
 */

public class Combination
{
    public static char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private StringBuilder output = new StringBuilder();
    private final String inputstring;
    public Combination( final String str ) {
    	inputstring = str;
    }

    public static void main(String[] args)
    {
        // Guaranteed n <=26 
        int n = Integer.parseInt(args[0]);
        String combination = "";
        for (int i = 0; i < n; i++)
            combination += letters[i];
        Combination combobj = new Combination(combination);
        combobj.combine();
    }
    public void combine() {combine(0);}
    public void combine(int start){
        for (int i = start; i < inputstring.length(); ++i) {
            output.append(inputstring.charAt(i));
            System.out.println(output);
            if (i < inputstring.length()) {
                combine(i+1);
                output.setLength(output.length() - 1);
        
            }
	    }
    }
}
