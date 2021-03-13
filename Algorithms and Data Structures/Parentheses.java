/* PROBLEM DESCRIPTION: Write a stack client Parentheses that reads a string of parentheses, squarebrackets, and curly braces from standard input and uses a stack to determinewhether they are properly balanced. For example, your program should printtrue for [()]{}{[()()]()} and false for [(])
 * 
 * DEPENDENCIES: Stack.java, StdIn.java, StdOut.java
 */ 

import java.util.*;

public class Parentheses
{
	public static boolean isBalanced(String p)
	{
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < p.length(); i++) {
			char x = p.charAt(i);
			if (x == '(' || x == '[' || x == '{')
			{ stack.push(x); continue; }
			if (stack.isEmpty()) return false;
			char check;
			switch(x) {
				case ')':
					check = stack.pop();
					if (check == '{' || check == '[')
						return false;
					break;
				case '}':
					check = stack.pop();
					if (check == '(' || check == '[')
						return false;
					break;
				case ']':
					check = stack.pop();
					if (check == '(' || check == '{')
						return false;
					break;
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String[] args)
	{
		String p = StdIn.readString();
		System.out.println(isBalanced(p));
		return;
	}
}
