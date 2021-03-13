/* PROBLEM DESCRIPTION: Write a program that takes from standard input an expression without left parentheses and prints the equivalent infix expression with the parentheses inserted. For example, given the input
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 *
 * DEPENDENCIES: Stack.java, StdIn.java, StdOut.java
 */

import java.util.Scanner;

public class ParenthesesCompleter {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		Stack<Character> operators = new Stack<Character>();
		Stack<String> operands = new Stack<>();

		for (int i = 0; i < line.length(); i++)
		{
			switch(line.charAt(i))
			{
				case '+':
				case '-':
				case '*':
				case '/':
					operators.push(line.charAt(i));
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					String s = "";
					s += line.charAt(i);
					operands.push(s);
					break;
				case ')':
					String a = operands.pop();
					String b = operands.pop();
					char c = operators.pop();

					StringBuilder buf = new StringBuilder();
					buf.append("(");
					buf.append(b);
					buf.append(c);
					buf.append(a);
					buf.append(")");

					operands.push(buf.toString());
					break;
				case ' ':
					break;
			}
		}
		while (!operators.isEmpty()) {
			String a = operands.pop();
			String b = operands.pop();
			char c = operators.pop();

			StringBuilder buf = new StringBuilder();
			buf.append(b);
			buf.append(c);
			buf.append(a);

			operands.push(buf.toString());
		}
		System.out.println(operands.pop());
		sc.close();
    }
}
