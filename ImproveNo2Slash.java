/**PROBLEM DESCRIPTION: The “beck” exploit. A popular web server supports a function named no2slash()whose purpose is to collapse multiple / characters. For example, the string/d1///d2////d3/test.html collapses to /d1/d2/d3/test.html. The original algorithmwas to repeatedly search for a / and copy the remainder of the string. Develop a version of no2slash() that runs in linear time.
 * 
 * Input: %java ImproveNo2Slash
 * 		   domain.com///d2////d3/test.html
 * Output: domain.com/d2/d3/test.html
 */

public class ImproveNo2Slash
{
    public static void main(String[] args)
    {
        
        String name= StdIn.readString() ;
		String out = "";
		int n = name.length();
		char [] c = name.toCharArray();
		for (int i = 1; i < n; i++)
		{
			if (c[i] == '/' && c[i-1] == '/')
				continue;
			else {
				if (i == 1) out += c[i-1];
				out += c[i];
			}
		}
		StdOut.println(out);

        return;
    }
}
