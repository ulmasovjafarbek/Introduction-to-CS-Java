/**PROBLEM DESCRIPTION: Safe password verification. Write a static method IsSafePassword that takes astring as an argument and returns true if it meets the following conditions, false otherwise:
 * 1. At least eight characters long
 * 2. Contains at least one digit (0-9)
 * 3. Contains at least one uppercase letter
 * 4. Contains at least one lowercase letter
 * 5. Contains at least one character that is neither a letter nor a number
 * Such checks are commonly used for passwords on the web.
 */

public class Password {
    public static void main(String[] args){
        String password = StdIn.readAll();
        
        boolean is_safe = IsSafePassword(password);
        
        System.out.println(is_safe);
    }
    public static boolean IsSafePassword(String password)
    {
	    int l = password.length();
	    boolean hasDigit = false, hasUpp = false, hasLow = false, hasChar = false;
	    if (l < 8) return false;
	    else {
	    	for (int i = 0; i < l; i++) {
				char ch = password.charAt(i);
				if (ch >= 'A' && ch <= 'Z')
					hasUpp = true;
				if (ch >= 'a' && ch <= 'z')
					hasLow = true;
				if (ch >= '0' && ch <= '9')
					hasDigit = true;
				if ((ch >= '!' && ch <= '/') || (ch >= ':' && ch <='@') || (ch >= '[' && ch <= '`') || (ch >= '{' && ch <= '~'))
					hasChar = true;
			}
	    }
	    if (hasDigit && hasUpp && hasLow && hasChar)
		    return true;
	    else return false;
	}
}

