/*
PROBLEM DESCRIPTION: make a program LookupAndPut that allows put operations to be specified on standard input. Use the convention that a plus sign indicates that the next two strings typed are the key–value pair to be inserted.

DEPENDENCIES: ST.java, Stack.java, StdIn.java, StdOut.java

EXAMPLE:
Input:
	java LookupAndPut
	+ xosmv agyqx
	+ himwx pcplt
	+ lcvrp genrb
	xosmv
	+ xosmv pcplt
	+ dnrmm mmaon
	lcvrp
	+ dtpgj xosmv
	zwdrw 
	+ nyskv nytar 
	zwdrw 
	agyqx 
	ubtpn 
	hfcqj 
	+ hvoqj genrb 
	ubtpn 
	+ phlgh genrb 
	+ dtpgj himwx 
	+ intln ncfjv 
	+ pcplt hvoqj 
	+ cegge qgzte 
	+ cegge somyh 
	+ somyh dtpgj 
	+ zwdrw somyh 
	+ kvwnt genrb 
	+ lepnw indkd 
	+ zwdrw xosmv 
	+ mmaon nytar 
	+ phlgh cegge 
	nytar 
	+ zwdrw dnrmm 
	+ nnnla nnnla
Output:
	agyqx 
	genrb 
	null 
	null 
	null 
	null 
	null 
	null 
	null
*/

import java.util.*;

public class LookupAndPut
{
    public static void main(String[] args)
    {
        ST<String, String> map = new ST<String, String>();        
		String[] database = StdIn.readAllLines();
		int i = 0;
		while (i < database.length) {
			String[] tokens = database[i].split(" ");
			if (tokens[0].equals("+")) {
				String key = tokens[1];
				String val = tokens[2];
				map.put(key, val);
			}
			else {
				if (map.contains(tokens[0]))
					System.out.println(map.get(tokens[0]));
				else
					System.out.println("null");
			}
			i++;
		}
        return;
    }
}
