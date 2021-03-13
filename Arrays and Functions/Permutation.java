/**PROBLEM DESCRIPTION: Write a program Permutation that takes an integer command-line argument nand prints all n ! permutations of the n letters starting at a (assume that n is nogreater than 26). A permutation of n elements is one of the possible orderings ofthe elements. You can seperate each permutation with a space or a new line.
 * 
 * Input: %java Permutation 3
 * Output: abc acb bac bca cba cab
 */

public class Permutation
{
    public static void main(String[] args)
    {
        int n  = Integer.parseInt(args[0]); 
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] arr = new char[n];
        for (int i=0;i<n;i++) arr[i] = alphabet.charAt(i);
        perm(arr, 0);
    }

    public static void perm(char[] arr, int start_pos){
        int end_pos = arr.length;
        if (start_pos ==  end_pos) System.out.println(new String(arr));
        else {
            for (int i = start_pos; i < end_pos; i++)
            {
                Swap(arr, start_pos, i);
                perm(arr, start_pos+1);
                Swap(arr, start_pos, i);
            }
        }
    }
    public static void Swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return;           
    }
}
