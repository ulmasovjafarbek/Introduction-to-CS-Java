/*
PROBLEM DESCRIPTION: Add code to TuringMachine to print a line with the state name, position of the tape head, and the tape contents eachtime the machine changes state. Modify the toString() method in Tape to leave in the meta-symbol # and mark theposition of the tape head by printing matching angle brackets before and a􀁸er the symbol under the tape head.

DEPENDENCIES: Tape.java, ST.java, Stack.java, In.java, StdIn.java, StdOut.java

EXAMPLE:
Input:
    java TuringMachine ab.txt
    ababab
Output:
    R        <a>b a b a b #    0 -> 0 scanning for  #a 
    R         a<b>a b a b #    0 -> 0 scanning for  #a 
    R         a b<0>b a b #    0 -> 0 scanning for  #a 
    R         a b 0<b>a b #    0 -> 0 scanning for  #a 
    R         a b 0 b<0>b #    0 -> 0 scanning for  #a 
    R         a b 0 b 0<b>#    0 -> 1 scanning for  #ab
    L         a b 0 b 0 b<#>   1 -> 1 scanning for  #ab
    L         a b 0 b 0<1>#    1 -> 1 scanning for  #ab
    L         a b 0 b<0>1 #    1 -> 1 scanning for  #ab
    L         a b 0<1>0 1 #    1 -> 1 scanning for  #ab
    L         a b<0>1 0 1 #    1 -> 1 scanning for  #ab
    L         a<1>0 1 0 1 #    1 -> 1 scanning for  #ab
    L        <0>1 0 1 0 1 #    1 -> 2 Halt
    Halt <#>0 1 0 1 0 1 #
*/

public class TuringMachine {
    private String[] action;
    private ST<Character, Integer>[] next;
    private ST<Character, Character>[] out;

    public TuringMachine(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        action = new String[n];
        next = (ST<Character, Integer>[]) new ST[n];
        out = (ST<Character, Character>[]) new ST[n];
        for (int st = 0; st < n; st++) {
            action[st] = in.readString();
            if (action[st].equals("Halt"))
                continue;
            if (action[st].equals("Yes"))
                continue;
            if (action[st].equals("No"))
                continue;
            next[st] = new ST<Character, Integer>();
            for (int i = 0; i < alphabet.length(); i++) {
                int state = in.readInt();
                next[st].put(alphabet.charAt(i), state);
            }
            out[st] = new ST<Character, Character>();
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = in.readString().charAt(0);
                out[st].put(alphabet.charAt(i), symbol);
            }
        }
    }

	public static String reverse(String s) {
		if (s.isEmpty()) return s;
		return reverse(s.substring(1)) + s.charAt(0);
	}

	public String tapeDisplay(Tape tape) {
		char curSym = tape.read();
		String oldTapeL = tape.left.toString();
		String oldTapeR = tape.right.toString();
		oldTapeL = oldTapeL.replaceAll("[\\],\\[]", "");
		oldTapeR = oldTapeR.replaceAll("[\\],\\[]", "");
		return (reverse(oldTapeL) + "<" + curSym + ">" + oldTapeR);
	}

    public  String scanFor(int curState){
	    String s = "";
	    for (char key : next[curState].keys()) {
	    	if (curState != next[curState].get(key) || key != out[curState].get(key))
			s += key;
	    }
	   return s;
    }
    public String simulate(String input) {
        Tape tape = new Tape(input);
        int state = 0;
        while (action[state].equals("L") || action[state].equals("R")) {
            
		int oldState = state;
		String tapeDisplay = tapeDisplay(tape);
		String currentAction = action[state];

            if (action[state].equals("R"))
                tape.moveRight();
            if (action[state].equals("L"))
                tape.moveLeft();
            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);

            if (action[state].equals("Halt"))
		        StdOut.printf("%s%23s%4s -> %s %s\n", currentAction, tapeDisplay, oldState, state, "Halt");		
	        else 
                StdOut.printf("%s%23s%4s -> %s scanning for  %s\n", currentAction, tapeDisplay, oldState, state, scanFor(state));
        }
        return action[state] + " " + tapeDisplay(tape);
    }

    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine(args[0]);
        while (StdIn.hasNextLine())
        {
            String temp= StdIn.readLine();
            if(temp.equals("-1")){
                StdOut.println("Terminated");
                break;
            }
            StdOut.println(tm.simulate(temp));
        }
    }
}
