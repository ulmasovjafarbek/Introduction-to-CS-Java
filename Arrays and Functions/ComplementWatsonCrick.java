/**PROBLEM DESCRIPTION: Write a function complementWatsonCrick() that takes a DNA string as itsargument and returns its Watson-Crick complement: replace A with T, C with G,and vice versa.
 * Input: ATGCGCTGCGTCTGTACTAG
 * Output: TACGCGACGCAGACATGATC
 */

public class ComplementWatsonCrick
{
    public static void main(String[] args) {
        String s = StdIn.readString();
            
        System.out.println( Complement(s));
    } 
    
    public static String Complement(String s){
        s = s.replaceAll("A", "a");
        s = s.replaceAll("T", "A");
        s = s.replaceAll("a", "T");
        s = s.replaceAll("C", "c");
        s = s.replaceAll("G", "C");
        s = s.replaceAll("c", "G");
        return s;
    }
}
