/*
PROBLEM DESCRIPTION: Develop a program SubsetSum that finds a solution to the subset sumproblem for any given set of numbers. Input format, the first number from stdin is the target sum, the rest of the inputintegers are the set of numbers to choose from. As in the following:
    int sum = StdIn.readInt(); 
    int []arr = StdIn.readAllInts();

DEPENDENCIES: StdOut.java, StdIn.java

EXAMPLE 1:
Input:
    java SATBasedSubset 
    8 
    1 2 4 6 <Ctrl-Z>
Output:
    0101

EXAMPLE 2:
Input:
    java SATBasedSubset 
    10 
    4 7 5 <Ctrl-Z>
Output:
    No solution found
*/

public class SATBasedSubset{

    private int sum;
    private int[] arr;
    private boolean[] inSubset;
    private static int n;

    public SATBasedSubset(int sum, int[] arr)
    {
        this.sum = sum;
        this.arr = arr;
        n = arr.length;
        inSubset = new boolean[n]; 
        while (next()){
            if(check(sum, inSubset, arr))
                return;
        }
    }

    private boolean next()
    {
        int i = n - 1;
        while (inSubset[i]) {
            inSubset[i--] = false;
            if (i == -1)
                return false;
        } inSubset[i] = true; return true;
    }


    public static boolean check(int sum, boolean[] inSubset, int []arr)
    {
        
        boolean check = false;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
                    inSubset[i] = true; inSubset[j] = true;
                    check = true;
                }
            }
        return check;

    }

    public String toString(){
        String solverString = new String("");
        for (int i = 0; i < inSubset.length; i++) {
            if (inSubset[i] == true) solverString += "1";
            else solverString += "0";
        }
        if (solverString.contains("1")) return solverString;
        else return "No solution found";
    }

    public static void main(String[] args){
        int sum = StdIn.readInt();
        int []arr = StdIn.readAllInts();
        SATBasedSubset solver = new SATBasedSubset(sum, arr); 
        StdOut.println(solver);
    }
}
