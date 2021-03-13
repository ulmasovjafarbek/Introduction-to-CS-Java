/**PROBLEM DESCRIPTION: Write a program that takes three floating-point numbers a, b, and c ascommand-line arguments and prints the two (complex) roots of ax^2 + bx + c == 0.
 * 
 * EXAMPLE: 
 * Input: java ComplexRoot 1 -3 2
 * Output:
 * 		1.0 + 0.0i
		2.0 + 0.0i
 * Input: java ComplexRoot 2 3 5 
 * Output: 
 * 		-0.75 + -1.3919410907075054i
		-0.75 + 1.3919410907075054i
 * Input: java ComplexRoot 1 -2 1
 * Output: 1.0 + 0.0i
 * Input: java ComplexRoot 0.0 0.0 0.0
 * Output: Infinite number of roots
 */

public class ComplexRoot
{
    public static void findRoots(double a, double b, double c)
    {
		double d = b * b - 4 * a * c;
		double sqrt_val = Math.sqrt(Math.abs(d));

		if (a == 0) {
			if (b == 0) {
				if (c == 0) System.out.println("Infinite number of roots");
				else System.out.println("No root");
			} return;
		}
		if (d > 0) {
			double r1 = (-b + sqrt_val) / (2 * a);
			double r2 = (-b - sqrt_val) / (2 * a);
			if (r1 < r2) System.out.println(r1 + " + 0.0i" + "\n" + r2 + " + 0.0i");
			else System.out.println(r2 + " + 0.0i" + "\n" + r1 + " + 0.0i");
		}
		else if (d == 0) {
			System.out.println(-(double)b / (2 * a) + " + 0.0i");
		}
		else 
		{
			double real = -b / (2 * a);
			double i = Math.sqrt(-d) / (2 * a);
			System.out.print(real + " + -" + Math.abs(i) + "i\n");
			System.out.print(real + " + " + Math.abs(i) + "i");
		}
    }
    public static void main(String[] args)
    {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        findRoots(a, b, c);
        return;
    }
}
